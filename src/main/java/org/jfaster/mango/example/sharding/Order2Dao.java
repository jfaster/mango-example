package org.jfaster.mango.example.sharding;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.Sharding;
import org.jfaster.mango.annotation.ShardingBy;
import org.jfaster.mango.sharding.ShardingStrategy;

import java.util.List;

/**
 * @author ash
 */
@DB(table = "order")
@Sharding(shardingStrategy = Order2Dao.OrderShardingStrategy.class)
public interface Order2Dao {

    @SQL("insert into #table(id, uid, price, status) values(:id, :uid, :price, :status)")
    void addOrder(@ShardingBy("uid") Order order);

    @SQL("select id, uid, price, status from #table where uid = :1")
    List<Order> getOrdersByUid(@ShardingBy int uid);

    class OrderShardingStrategy implements ShardingStrategy<Integer, Integer> {

        @Override
        public String getDatabase(Integer uid) {
            return "db" + ((uid / 10) % 2 + 1);
        }

        @Override
        public String getTargetTable(String table, Integer uid) {
            return table + "_" + (uid % 10);
        }

    }

}





