package org.jfaster.mango.example.partition;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.ShardBy;
import org.jfaster.mango.example.model.User;
import org.jfaster.mango.partition.IntegerModTenTablePartition;

@DB(
        table = "user",
        dataSourceRouter = MyDataSourceRouter.class,
        tablePartition = IntegerModTenTablePartition.class
)
public interface User2Dao {

    @SQL("insert into #table(uid, name) values(:1, :2)")
    public void addUser(@ShardBy int uid, String name);

    @SQL("select uid, name from #table where uid = :1")
    public User getUser(@ShardBy int uid);

}
