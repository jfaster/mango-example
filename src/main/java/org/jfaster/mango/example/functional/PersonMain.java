package org.jfaster.mango.example.functional;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;

/**
 * @author ash
 */
public class PersonMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

        PersonDao dao = mango.create(PersonDao.class);
        Person person = new Person();
        person.setName("ash");
        person.setGender(Gender.MALE);
        int id = dao.addPerson(person);
        Person personFromDb = dao.getPersonById(id);
        System.out.println("name=" + personFromDb.getName());
        System.out.println("gender=" + personFromDb.getGender());
    }

}
