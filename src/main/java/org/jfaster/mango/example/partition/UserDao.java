package org.jfaster.mango.example.partition;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.DataSourceShardBy;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.TableShardBy;
import org.jfaster.mango.example.cache.User;
import org.jfaster.mango.partition.IntegerModTenTablePartition;

@DB(
        table = "user",
        dataSourceRouter = MyDataSourceRouter.class,
        tablePartition = IntegerModTenTablePartition.class
)
public interface UserDao {

    @SQL("insert into #table(uid, name) values(:1, :2)")
    public void addUser(@DataSourceShardBy @TableShardBy int uid, String name);

    @SQL("select uid, name from #table where uid = :1")
    public User getUser(@DataSourceShardBy @TableShardBy int uid);

}
