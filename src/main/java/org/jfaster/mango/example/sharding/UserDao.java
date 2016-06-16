package org.jfaster.mango.example.sharding;

import org.jfaster.mango.annotation.*;
import org.jfaster.mango.example.cache.User;
import org.jfaster.mango.sharding.ModTenTableShardingStrategy;

@DB(table = "user")
@Sharding(
        databaseShardingStrategy = MyDatabaseShardingStrategy.class,
        tableShardingStrategy = ModTenTableShardingStrategy.class
)
public interface UserDao {

    @SQL("insert into #table(uid, name) values(:1, :2)")
    public void addUser(@DatabaseShardingBy @TableShardingBy int uid, String name);

    @SQL("select uid, name from #table where uid = :1")
    public User getUser(@DatabaseShardingBy @TableShardingBy int uid);

}
