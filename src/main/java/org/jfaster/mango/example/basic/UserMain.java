package org.jfaster.mango.example.basic;

import com.google.common.collect.Lists;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Date;

/**
 * @author ash
 */
public class UserMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

        UserDao dao = mango.create(UserDao.class);
        String name = "ash";
        int age = 28;
        boolean gender = true;
        long money = 100;
        Date updateTime = new Date();

        dao.insertUser(name, age, gender, money, updateTime);

        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);
        user.setMoney(money);
        user.setUpdateTime(updateTime);

        int id = dao.insertUser(user);
        System.out.println(id);

        dao.deleteUser(id);

        int id2 = dao.insertUser(user);
        int id3 = dao.insertUser(user);

        user.setId(id2);
        user.setName("lucy");
        dao.updateUser(user);
        System.out.println(dao.getName(id2));
        System.out.println(dao.getUser(id2));
        System.out.println(dao.getUsersByAge(age));
        System.out.println(dao.getUsersInList(Lists.newArrayList(id2, id3)));

        int[] r = dao.batchInsertUserList(Lists.newArrayList(user, user, user));
        System.out.println(Arrays.toString(r));
    }

}
