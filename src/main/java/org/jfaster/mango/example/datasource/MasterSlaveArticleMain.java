package org.jfaster.mango.example.datasource;

import org.jfaster.mango.datasource.DataSourceFactory;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.datasource.MasterSlaveDataSourceFactory;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;
import java.util.Arrays;

public class MasterSlaveArticleMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码

        // 连主库的数据源
        DataSource master = new DriverManagerDataSource(driverClassName, url, username, password);

        // 连从库的数据库，为了简单，参数与主库一致，实际情况下从库有不同的url，username，password
        DataSource slave1 = new DriverManagerDataSource(driverClassName, url, username, password);
        DataSource slave2 = new DriverManagerDataSource(driverClassName, url, username, password);

        DataSourceFactory dsf = new MasterSlaveDataSourceFactory(master, Arrays.asList(slave1, slave2));
        Mango mango = Mango.newInstance(dsf);

        ArticleDao dao = mango.create(ArticleDao.class);
        Article article = new Article();
        article.setUid(9527);
        article.setTitle("article_title");
        article.setContent("article_content");

        int id = dao.addArticle(article);
        System.out.println(dao.getArticle(id));
    }

}