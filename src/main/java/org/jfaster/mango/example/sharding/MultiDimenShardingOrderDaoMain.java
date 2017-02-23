package org.jfaster.mango.example.sharding;

import com.google.common.collect.Lists;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.Sharding;
import org.jfaster.mango.annotation.ShardingBy;
import org.jfaster.mango.datasource.DataSourceFactory;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.datasource.SimpleDataSourceFactory;
import org.jfaster.mango.example.util.RandomUtils;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.sharding.ShardingStrategy;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ash
 */
public class MultiDimenShardingOrderDaoMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码

        int dbNum = 3;
        List<DataSourceFactory> dsfs = new ArrayList<DataSourceFactory>();
        for (int i = 0; i < dbNum; i++) {
            String name = "dsf" + i;
            String url = "jdbc:mysql://localhost:3306/db" + i;
            DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
            DataSourceFactory dsf = new SimpleDataSourceFactory(name, ds);
            dsfs.add(dsf);
        }
        Mango mango = Mango.newInstance(dsfs);
        MultiDimenShardingOrderDao orderDao = mango.create(MultiDimenShardingOrderDao.class);

        List<Integer> uids = Lists.newArrayList(1, 2, 3, 30001, 30002, 30003);
        for (Integer uid : uids) {
            String randomId = RandomUtils.randomStringId(10); // 随机生成10位字符串ID
            String holderMark = "1"; // 订单ID首位永远为1，避免为0
            String databaseMark = uid % 3 + "";
            String tableMark = uid <= 1000 ? "0" : "1";
            String id = holderMark + databaseMark + tableMark + randomId; // ID前添加分库分表标记
            Order order = new Order();
            order.setId(id);
            order.setUid(uid);
            order.setPrice(100);
            order.setStatus(1);

            orderDao.addOrder(order);
            System.out.println(orderDao.getOrdersByUid(uid));
            System.out.println(orderDao.getOrderById(id));
        }
    }

    @DB(table = "t_order")
    public interface MultiDimenShardingOrderDao {

        @SQL("insert into #table(id, uid, price, status) values(:id, :uid, :price, :status)")
        @Sharding(shardingStrategy = OrderUidShardingStrategy.class)
        public void addOrder(@ShardingBy("uid") Order order);

        @SQL("select id, uid, price, status from #table where uid = :1")
        @Sharding(shardingStrategy = OrderUidShardingStrategy.class)
        public List<Order> getOrdersByUid(@ShardingBy int uid);

        @SQL("select id, uid, price, status from #table where id = :1")
        @Sharding(shardingStrategy = OrderIdShardingStrategy.class)
        public Order getOrderById(@ShardingBy String id);

    }

    static class OrderUidShardingStrategy implements ShardingStrategy<Integer, Integer> {

        @Override
        public String getDataSourceFactoryName(Integer uid) {
            return "dsf" + uid % 3;
        }

        @Override
        public String getTargetTable(String table, Integer uid) {
            int num = uid <= 1000 ? 0 : 1;
            return table + "_" + num;
        }

    }

    static class OrderIdShardingStrategy implements ShardingStrategy<String, String> {

        @Override
        public String getDataSourceFactoryName(String orderId) {
            return "dsf" + orderId.substring(1, 2);
        }

        @Override
        public String getTargetTable(String table, String orderId) {
            return table + "_" + orderId.substring(2, 3);
        }

    }

}
