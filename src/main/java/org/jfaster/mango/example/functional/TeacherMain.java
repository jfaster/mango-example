package org.jfaster.mango.example.functional;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

/**
 * @author ash
 */
public class TeacherMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

        TeacherDao dao = mango.create(TeacherDao.class);
        Teacher teacher = new Teacher();
        String name = "ash";
        List<Integer> studentIds = Arrays.asList(1, 2, 3);
        teacher.setName(name);
        teacher.setStudentIds(studentIds);
        int id = dao.addTeacher(teacher);
        Teacher teacherFromDb = dao.getTeacherById(id);
        System.out.println("name=" + teacherFromDb.getName());
        System.out.println("studentIds=" + teacherFromDb.getStudentIds());
    }

}
