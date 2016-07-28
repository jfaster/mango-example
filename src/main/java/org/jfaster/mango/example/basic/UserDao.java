package org.jfaster.mango.example.basic;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

import java.util.Date;
import java.util.List;

/**
 * @author ash
 */
@DB
public interface UserDao {

    @SQL("insert into user(name, age, gender, money, update_time) values(:1, :2, :3, :4, :5)")
    public void insertUser(String name, int age, boolean gender, long money, Date updateTime);

    @ReturnGeneratedId
    @SQL("insert into user(name, age, gender, money, update_time) " +
            "values(:1.name, :1.age, :1.gender, :1.money, :1.updateTime)")
    public int insertUser(User user);

    @SQL("delete from user where id=:1")
    public int deleteUser(int id);

    @SQL("update user set name=:1.name, age=:1.age, gender=:1.gender, " +
            "money=:1.money, update_time=:1.updateTime where id=:1.id")
    public int updateUser(User user);

    @SQL("select name from user where id = :1")
    public String getName(int id);

    @SQL("select id, name, age, gender, money, update_time from user where id = :1")
    public User getUser(int id);

    @SQL("select id, name, age, gender, money, update_time from user where age=:1 order by id")
    public List<User> getUsersByAge(int age);

    @SQL("select id, name, age, gender, money, update_time from user where id in (:1)")
    public List<User> getUsersInList(List<Integer> ids);

    @SQL("insert into user(name, age, gender, money, update_time) " +
            "values(:1.name, :1.age, :1.gender, :1.money, :1.updateTime)")
    public int[] batchInsertUserList(List<User> userList);


}
