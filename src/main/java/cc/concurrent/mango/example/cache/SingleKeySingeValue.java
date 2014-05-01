package cc.concurrent.mango.example.cache;

import cc.concurrent.mango.DriverManagerDataSource;
import cc.concurrent.mango.Mango;

import javax.sql.DataSource;

public class SingleKeySingeValue {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_db";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = new Mango(ds, new CacheHandlerImpl()); // 使用数据源和CacheHandlerImpl初始化mango

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
