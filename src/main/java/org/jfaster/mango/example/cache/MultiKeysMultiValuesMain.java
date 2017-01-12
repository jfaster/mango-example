package org.jfaster.mango.example.cache;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;
import java.util.Arrays;

public class MultiKeysMultiValuesMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds);
        mango.setCacheHandler(new MockRedisHandler());

        MultiKeysMultiValuesDao dao = mango.create(MultiKeysMultiValuesDao.class);
        dao.insert(100, "ash");
        dao.insert(200, "lucy");
        dao.insert(300, "lily");
        System.out.println(dao.getUsers(Arrays.asList(100, 200, 300)));
    }

}
