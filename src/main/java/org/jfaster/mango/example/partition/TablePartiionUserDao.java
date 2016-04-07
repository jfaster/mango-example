package org.jfaster.mango.example.partition;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.TableShardBy;
import org.jfaster.mango.example.model.User;
import org.jfaster.mango.partition.IntegerModTenTablePartition;

@DB(table = "user", tablePartition = IntegerModTenTablePartition.class)
public interface TablePartiionUserDao {

    @SQL("insert into #table(uid, name) values(:1, :2)")
    public void addUser(@TableShardBy int uid, String name);

    @SQL("select uid, name from #table where uid = :1")
    public User getUser(@TableShardBy int uid);

}
