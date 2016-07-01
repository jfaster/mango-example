package org.jfaster.mango.example.sharding;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.DatabaseShardingBy;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.Sharding;

@DB()
@Sharding(databaseShardingStrategy = UserDatabaseShardingStrategy.class)
public interface DatabaseShardingUserDao {

    @SQL("insert into user(uid, name) values(:uid, :name)")
    public void addUser(@DatabaseShardingBy("uid") User user);

    @SQL("select uid, name from user where uid = :1")
    public User getUser(@DatabaseShardingBy int uid);

}
