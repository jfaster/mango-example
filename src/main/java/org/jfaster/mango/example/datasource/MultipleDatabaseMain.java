package org.jfaster.mango.example.datasource;

import org.jfaster.mango.datasource.*;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ash
 */
public class MultipleDatabaseMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码

        // 主从数据库数据源工厂
        String url1 = "jdbc:mysql://localhost:3306/mango_example_db1";
        DataSource master = new DriverManagerDataSource(driverClassName, url1, username, password);
        int slaveNum = 2;
        List<DataSource> slaves = new ArrayList<DataSource>();
        for (int i = 0; i < slaveNum; i++) {
            // 为了简单，参数与主库一致，实际情况下从库有不同的url，username，password
            slaves.add(new DriverManagerDataSource(driverClassName, url1, username, password));
        }
        DataSourceFactory db1DataSourceFactory = new MasterSlaveDataSourceFactory(master, slaves);

        // 单一数据库数据源工厂
        String url2 = "jdbc:mysql://localhost:3306/mango_example_db2";
        DataSource ds = new DriverManagerDataSource(driverClassName, url2, username, password);
        DataSourceFactory db2DataSourceFactory = new SimpleDataSourceFactory(ds);

        Map<String, DataSourceFactory> factories = new HashMap<String, DataSourceFactory>();
        factories.put("db1", db1DataSourceFactory); // db1对应主从数据库数据源工厂
        factories.put("db2", db2DataSourceFactory); // db2单一数据库数据源工厂
        DataSourceFactory dsf = new MultipleDatabaseDataSourceFactory(factories);
        Mango mango = Mango.newInstance(dsf);

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
