package org.jfaster.mango.example.binding;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;

/**
 * @author ash
 */
public class BindingMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

        BindingUserDao dao = mango.create(BindingUserDao.class);
        int uid = 9527;
        String name = "ash";
        int age = 28;
        BindingUser user = new BindingUser();
        user.setUid(uid);
        user.setName(name);
        user.setAge(age);

        dao.addUserByIndex(uid, name, age);
        dao.addUserByRename(uid, name, age);
        dao.addUserByObjIndex(user);
        dao.addUserByObjRename(user);
        dao.addUserByProperty(user);
        dao.addUserByMix(uid, user);

        System.out.println(dao.getUsersByUid(uid));
    }

}
