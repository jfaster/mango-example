package org.jfaster.mango.example.sharding;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.Sharding;
import org.jfaster.mango.annotation.ShardingBy;
import org.jfaster.mango.example.cache.User;
import org.jfaster.mango.sharding.ModTenTableShardingStrategy;

@DB(table = "user")
@Sharding(
        databaseShardingStrategy = MyDatabaseShardingStrategy.class,
        tableShardingStrategy = ModTenTableShardingStrategy.class
)
public interface User2Dao {

    @SQL("insert into #table(uid, name) values(:1, :2)")
    public void addUser(@ShardingBy int uid, String name);

    @SQL("select uid, name from #table where uid = :1")
    public User getUser(@ShardingBy int uid);

}
