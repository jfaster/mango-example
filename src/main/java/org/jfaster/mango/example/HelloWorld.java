package org.jfaster.mango.example;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;

public class HelloWorld {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_db";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = new Mango(ds); // 使用数据源初始化mango

        HelloWorldDao dao = mango.create(HelloWorldDao.class);
        int id = 1;
        dao.add(id, "hello world");
        String content = dao.getContentById(id);
        System.out.println(content);
    }

    @DB
    static interface HelloWorldDao {

        @SQL("insert into hello_world_table(id, content) values(:1, :2)")
        public int add(int id, String content);

        @SQL("select content from hello_world_table where id=:1")
        public String getContentById(int id);

    }

}