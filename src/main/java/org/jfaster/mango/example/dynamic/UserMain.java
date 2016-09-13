package org.jfaster.mango.example.dynamic;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.util.logging.MangoLogger;

import javax.sql.DataSource;

/**
 * @author ash
 */
public class UserMain {

    public static void main(String[] args) {

        // 使用System.out输出sql，方便查看
        MangoLogger.useConsoleLogger();

        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

        UserDao dao = mango.create(UserDao.class);

        dao.getUsers("uid");
        dao.getUsers("name");

        dao.getUser(10);
        dao.getUser(-1);

        dao.getUser2(10);
        dao.getUser2(0);
        dao.getUser2(-5);

    }

}
