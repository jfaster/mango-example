package org.jfaster.mango.example.cache;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;
import java.util.Arrays;

public class MultiKeysMultiValues {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_db";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = new Mango(ds, new CacheHandlerImpl()); // 使用数据源和CacheHandlerImpl初始化mango

        MultiKeysMultiValuesDao dao = mango.create(MultiKeysMultiValuesDao.class);
        dao.insert(1, "ash");
        dao.insert(2, "lucy");
        dao.insert(3, "lily");
        System.out.println(dao.getUsers(Arrays.asList(1, 2, 3)));
    }

}
