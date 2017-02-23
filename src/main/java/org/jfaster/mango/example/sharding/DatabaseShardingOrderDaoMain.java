package org.jfaster.mango.example.sharding;

import com.google.common.collect.Lists;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.DatabaseShardingBy;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.Sharding;
import org.jfaster.mango.datasource.DataSourceFactory;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.datasource.SimpleDataSourceFactory;
import org.jfaster.mango.example.util.RandomUtils;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.sharding.DatabaseShardingStrategy;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ash
 */
public class DatabaseShardingOrderDaoMain {

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
        DatabaseShardingOrderDao orderDao = mango.create(DatabaseShardingOrderDao.class);

        List<Integer> uids = Lists.newArrayList(1, 2, 3, 4, 5);
        for (Integer uid : uids) {
            String id = RandomUtils.randomStringId(10); // 随机生成10位字符串ID
            Order order = new Order();
            order.setId(id);
            order.setUid(uid);
            order.setPrice(100);
            order.setStatus(1);

            orderDao.addOrder(order);
            System.out.println(orderDao.getOrdersByUid(uid));
        }
    }

    @DB()
    @Sharding(databaseShardingStrategy = OrderDatabaseShardingStrategy.class)
    public interface DatabaseShardingOrderDao {

        @SQL("insert into t_order(id, uid, price, status) values(:id, :uid, :price, :status)")
        public void addOrder(@DatabaseShardingBy("uid") Order order);

        @SQL("select id, uid, price, status from t_order where uid = :1")
        public List<Order> getOrdersByUid(@DatabaseShardingBy int uid);

    }

    static class OrderDatabaseShardingStrategy implements DatabaseShardingStrategy<Integer> {

        @Override
        public String getDataSourceFactoryName(Integer uid) {
            return "dsf" + uid % 3;
        }

    }

}
