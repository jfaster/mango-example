package org.jfaster.mango.example.datasource;

import org.jfaster.mango.datasource.DataSourceFactory;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.datasource.SimpleDataSourceFactory;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;

public class ArticleMain {

        public static void main(String[] args) {
            String driverClassName = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mango_example";
            String username = "root"; // 这里请使用您自己的用户名
            String password = "root"; // 这里请使用您自己的密码

            DataSource datasource = new DriverManagerDataSource(driverClassName, url, username, password);
            DataSourceFactory dsf = new SimpleDataSourceFactory(datasource);
            Mango mango = Mango.newInstance(dsf);
            //Mango mango = Mango.newInstance(datasource);

            ArticleDao dao = mango.create(ArticleDao.class);
            Article article = new Article();
            article.setUid(9527);
            article.setTitle("article_title");
            article.setContent("article_content");

            int id = dao.addArticle(article);
            System.out.println(dao.getArticle(id));
        }

}