package org.jfaster.mango.example.binding;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.Rename;
import org.jfaster.mango.annotation.SQL;

import java.util.List;

/**
 * @author ash
 */
@DB
public interface BindingUserDao {

    @SQL("insert into binding_user(uid, name, age) values(:1, :2, :3)")
    public void addUserByIndex(int uid, String name, int age);

    @SQL("insert into binding_user(uid, name, age) values(:uid, :name, :age)")
    void addUserByRename(@Rename("uid") int uid, @Rename("name") String name, @Rename("age") int age);

//    @SQL("insert into binding_user(uid, name, age) values(:1, :name, :age)")
//    void addUserError(@Rename("uid") int uid, @Rename("name") String name, @Rename("age") int age);

    @SQL("insert into binding_user(uid, name, age) values(:1.uid, :1.name, :1.age)")
    public void addUserByObjIndex(BindingUser user);

    @SQL("insert into binding_user(uid, name, age) values(:u.uid, :u.name, :u.age)")
    public void addUserByObjRename(@Rename("u") BindingUser user);

    @SQL("insert into binding_user(uid, name, age) values(:uid, :name, :age)")
    public void addUserByProperty(BindingUser user);

    @SQL("insert into binding_user(uid, name, age) values(:myuid, :name, :age)")
    public void addUserByMix(@Rename("myuid") int uid, BindingUser user);

    @SQL("select uid, name, age from binding_user where uid = :1")
    public List<BindingUser> getUsersByUid(int uid);

}
