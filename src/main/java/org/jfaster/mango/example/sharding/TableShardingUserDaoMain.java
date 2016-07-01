package org.jfaster.mango.example.sharding;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;

/**
 * @author ash
 */
public class TableShardingUserDaoMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds);

        TableShardingUserDao userDao = mango.create(TableShardingUserDao.class);

        // 需要在mango_example库中创建一张user_8的表
        int uid = 87;
        User user = userDao.getUser(uid);
        if (user == null) {
            user = new User();
            user.setUid(uid);
            user.setName("ash");
            userDao.addUser(user);
            System.out.println("add new user " + user);
        } else {
            System.out.println("get user from db " + user);
        }
    }

}
