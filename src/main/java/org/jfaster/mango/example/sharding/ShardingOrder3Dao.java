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
@DB(table = "t_order")
public interface ShardingOrder3Dao {

    @SQL("insert into #table(id, uid, price, status) values(:id, :uid, :price, :status)")
    @Sharding(shardingStrategy = ShardingOrder3Dao.OrderUidShardingStrategy.class)
    void addOrder(@ShardingBy("uid") Order order);

    @SQL("select id, uid, price, status from #table where uid = :1")
    @Sharding(shardingStrategy = ShardingOrder3Dao.OrderUidShardingStrategy.class)
    List<Order> getOrdersByUid(@ShardingBy int uid);

    @SQL("select id, uid, price, status from #table where id = :1")
    @Sharding(shardingStrategy = OrderIdShardingStrategy.class)
    Order getOrderById(@ShardingBy String id);

    class OrderUidShardingStrategy implements ShardingStrategy<Integer, Integer> {

        @Override
        public String getDataSourceFactoryName(Integer uid) {
            return uid < 1000 ? "db1" : "db2";
        }

        @Override
        public String getTargetTable(String table, Integer uid) {
            return table + "_" + (uid % 2);
        }

    }

    class OrderIdShardingStrategy implements ShardingStrategy<String, String> {

        @Override
        public String getDataSourceFactoryName(String orderId) {
            return "db" + orderId.substring(0, 1);
        }

        @Override
        public String getTargetTable(String table, String orderId) {
            return table + "_" + orderId.substring(1, 2);
        }

    }

}





