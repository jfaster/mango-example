package org.jfaster.mango.example.cache;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;

public class SingleKeySingeValueMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds);
        mango.setCacheHandler(new MockRedisHandler());

        SingleKeySingeValueDao dao = mango.create(SingleKeySingeValueDao.class);
        dao.insert(1, "ash");
        dao.insert(2, "lucy");
        System.out.println(dao.getUser(1));
        System.out.println(dao.getUser(2));
        dao.update(2, "lily");
        System.out.println(dao.getUser(2));
        dao.delete(1);
        System.out.println(dao.getUser(1));
    }

}
