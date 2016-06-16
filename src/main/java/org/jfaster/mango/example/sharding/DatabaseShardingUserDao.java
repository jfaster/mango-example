package org.jfaster.mango.example.sharding;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.DatabaseShardingBy;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.Sharding;
import org.jfaster.mango.example.cache.User;

@DB(table = "user")
@Sharding(databaseShardingStrategy = MyDatabaseShardingStrategy.class)
public interface DatabaseShardingUserDao {

    @SQL("insert into #table(uid, name) values(:1, :2)")
    public void addUser(@DatabaseShardingBy int uid, String name);

    @SQL("select uid, name from #table where uid = :1")
    public User getUser(@DatabaseShardingBy int uid);

}
