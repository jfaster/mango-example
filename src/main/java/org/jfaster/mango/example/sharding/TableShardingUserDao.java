package org.jfaster.mango.example.sharding;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.Sharding;
import org.jfaster.mango.annotation.TableShardingBy;

@DB(table = "user")
@Sharding(tableShardingStrategy = UserTableShardingStrategy.class)
public interface TableShardingUserDao {

    @SQL("insert into #table(uid, name) values(:uid, :name)")
    public void addUser(@TableShardingBy("uid") User user);

    @SQL("select uid, name from #table where uid = :1")
    public User getUser(@TableShardingBy int uid);

}
