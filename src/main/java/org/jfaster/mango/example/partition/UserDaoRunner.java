package org.jfaster.mango.example.partition;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;

/**
 * @author ash
 */
public class UserDaoRunner {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds);

        UserDao userDao = mango.create(UserDao.class);

        // 需要在mango_example库中创建一张user_8的表
        int uid = 88;
        String name = "ash";
        userDao.addUser(uid, name);
        System.out.println(userDao.getUser(uid));
    }

}
