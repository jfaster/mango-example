package org.jfaster.mango.example.sharding;

import org.jfaster.mango.annotation.*;
import org.jfaster.mango.sharding.TableShardingStrategy;

import java.util.List;

@DB(table = "order")
@Sharding(tableShardingStrategy = TableShardingOrderDao.OrderTableShardingStrategy.class)
public interface TableShardingOrderDao {

    @SQL("insert into #table(id, uid, price, status) values(:id, :uid, :price, :status)")
    public void addOrder(@TableShardingBy("uid") Order order);

    @SQL("select id, uid, price, status from #table where uid = :1")
    public List<Order> getOrdersByUid(@TableShardingBy int uid);

    class OrderTableShardingStrategy implements TableShardingStrategy<Integer> {

        @Override
        public String getTargetTable(String table, Integer shardingParameter) {
            return table + "_" + (shardingParameter % 2);
        }

    }

}
