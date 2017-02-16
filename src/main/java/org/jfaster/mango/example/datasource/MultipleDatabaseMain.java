package org.jfaster.mango.example.datasource;

import org.jfaster.mango.datasource.DataSourceFactory;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.datasource.MasterSlaveDataSourceFactory;
import org.jfaster.mango.datasource.SimpleDataSourceFactory;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

/**
 * @author ash
 */
public class MultipleDatabaseMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码

        // 主从数据源工厂，为了简单，从库参数与主库一致
        String url1 = "jdbc:mysql://localhost:3306/mango_example_db1";
        String name1 = "dsf1";
        DataSource master = new DriverManagerDataSource(driverClassName, url1, username, password);
        DataSource slave1 = new DriverManagerDataSource(driverClassName, url1, username, password);
        DataSource slave2 = new DriverManagerDataSource(driverClassName, url1, username, password);
        List<DataSource> slaves = Arrays.asList(slave1, slave2);
        DataSourceFactory dsf1 = new MasterSlaveDataSourceFactory(name1, master, slaves);

        // 简单数据源工厂
        String name2 = "dsf2";
        String url2 = "jdbc:mysql://localhost:3306/mango_example_db2";
        DataSource datasource = new DriverManagerDataSource(driverClassName, url2, username, password);
        DataSourceFactory dsf2 = new SimpleDataSourceFactory(name2, datasource);

        Mango mango = Mango.newInstance(Arrays.asList(dsf1, dsf2));

        BlogDao blogDao = mango.create(BlogDao.class);
        Blog blog = new Blog();
        blog.setUid(9527);
        blog.setTitle("blog_title");
        blog.setContent("blog_content");

        int blogId = blogDao.addBlog(blog);
        System.out.println(blogDao.getBlog(blogId));

        CommentDao commentDao = mango.create(CommentDao.class);
        Comment comment = new Comment();
        comment.setUid(9527);
        comment.setTitle("comment_title");
        comment.setContent("comment_content");

        int commentId = commentDao.addComment(comment);
        System.out.println(commentDao.getComment(commentId));
    }

}
