package org.jfaster.mango.example.sharding;

import org.jfaster.mango.annotation.*;
import org.jfaster.mango.sharding.DatabaseShardingStrategy;
import org.jfaster.mango.sharding.TableShardingStrategy;

import java.util.List;

/**
 * @author ash
 */
@DB(table = "order")
@Sharding(
        databaseShardingStrategy = OrderDao.OrderDatabaseShardingStrategy.class,
        tableShardingStrategy = OrderDao.OrderTableShardingStrategy.class
)
public interface OrderDao {


    @SQL("insert into #table(id, uid, price, status) values(:id, :uid, :price, :status)")
    void addOrder(@DatabaseShardingBy("uid") @TableShardingBy("uid") Order order);

    @SQL("select id, uid, price, status from #table where uid = :1")
    List<Order> getOrdersByUid(@DatabaseShardingBy @TableShardingBy int uid);

    class OrderDatabaseShardingStrategy implements DatabaseShardingStrategy<Integer> {

        @Override
        public String getDatabase(Integer uid) {
            return "db" + ((uid / 10) % 2 + 1);
        }

    }

    class OrderTableShardingStrategy implements TableShardingStrategy<Integer> {

        @Override
        public String getTargetTable(String table, Integer uid) {
            return table + "_" + (uid % 10);
        }

    }

}





