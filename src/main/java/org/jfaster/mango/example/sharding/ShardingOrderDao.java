package org.jfaster.mango.example.sharding;

import org.jfaster.mango.annotation.*;
import org.jfaster.mango.sharding.DatabaseShardingStrategy;
import org.jfaster.mango.sharding.TableShardingStrategy;

import java.util.List;

/**
 * @author ash
 */
@DB(table = "t_order")
@Sharding(
        databaseShardingStrategy = ShardingOrderDao.OrderDatabaseShardingStrategy.class,
        tableShardingStrategy = ShardingOrderDao.OrderTableShardingStrategy.class
)
public interface ShardingOrderDao {

    @SQL("insert into #table(id, uid, price, status) values(:id, :uid, :price, :status)")
    public void addOrder(@DatabaseShardingBy("uid") @TableShardingBy("uid") Order order);

    @SQL("select id, uid, price, status from #table where uid = :1")
    public List<Order> getOrdersByUid(@DatabaseShardingBy @TableShardingBy int uid);

    class OrderDatabaseShardingStrategy implements DatabaseShardingStrategy<Integer> {

        @Override
        public String getDatabase(Integer uid) {
            return uid < 1000 ? "db1" : "db2";
        }

    }

    class OrderTableShardingStrategy implements TableShardingStrategy<Integer> {

        @Override
        public String getTargetTable(String table, Integer uid) {
            return table + "_" + (uid % 2);
        }

    }

}





