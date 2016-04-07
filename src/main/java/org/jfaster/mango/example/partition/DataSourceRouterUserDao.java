package org.jfaster.mango.example.partition;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.DataSourceShardBy;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.example.model.User;

@DB(table = "user", dataSourceRouter = MyDataSourceRouter.class)
public interface DataSourceRouterUserDao {

    @SQL("insert into #table(uid, name) values(:1, :2)")
    public void addUser(@DataSourceShardBy int uid, String name);

    @SQL("select uid, name from #table where uid = :1")
    public User getUser(@DataSourceShardBy int uid);

}
