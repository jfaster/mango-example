package org.jfaster.mango.example.dynamic;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import java.util.List;

/**
 * @author ash
 */
@DB
public interface UserDao {

    @SQL("select uid, name from user order by #{:1}")
    public List<User> getUsers(String orderBy);

    @SQL("select uid, name from user where #if(:1>0) uid=:1 #else uid=-1 #end")
    public User getUser(int uid);

    @SQL("select uid, name from user where #if(:1>0) uid=:1 #elseif(:1==0) uid=1 #else uid=-1 #end")
    public User getUser2(int uid);

}
