package org.jfaster.mango.example.mapping;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author ash
 */
public class MappingMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

        MappingDao dao = mango.create(MappingDao.class);
        MappingUser u1 = new MappingUser();
        u1.setName("ash");
        u1.setUserAge(25);
        u1.setUpdateTime(new Date());
        System.out.println(u1);
        int id1 = dao.addMappingUser(u1);
        MappingUser u2 = new MappingUser();
        u2.setName("lucy");
        u2.setUserAge(18);
        u2.setUpdateTime(new Date());
        int id2 = dao.addMappingUser(u2);
        List<Integer> ids = Arrays.asList(id1, id2);

        System.out.println(dao.getNameById(id1));
        System.out.println(dao.getIdsLimit(2));
        System.out.println(dao.getMappingUserById(id1));
        System.out.println(dao.getMappingUsersById(ids));
        System.out.println(dao.getMappingUser2ById(id1));
        System.out.println(dao.getMappingUsers2ById(ids));
        System.out.println(dao.getMappingUserByIdMapper(id1));
        System.out.println(dao.getMappingUsersByIdMapper(ids));
    }

}
