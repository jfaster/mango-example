package org.jfaster.mango.example.sharding;

import org.jfaster.mango.annotation.*;
import org.jfaster.mango.sharding.DatabaseShardingStrategy;

import java.util.List;

@DB()
@Sharding(databaseShardingStrategy = DatabaseShardingOrderDao.OrderDatabaseShardingStrategy.class)
public interface DatabaseShardingOrderDao {

    @SQL("insert into t_order(id, uid, price, status) values(:id, :uid, :price, :status)")
    public void addOrder(@DatabaseShardingBy("uid") Order order);

    @SQL("select id, uid, price, status from t_order where uid = :1")
    public List<Order> getOrdersByUid(@DatabaseShardingBy int uid);

    class OrderDatabaseShardingStrategy implements DatabaseShardingStrategy<Integer> {

        @Override
        public String getDatabase(Integer shardingParameter) {
            return shardingParameter < 1000 ? "db1" : "db2";
        }

    }

}
