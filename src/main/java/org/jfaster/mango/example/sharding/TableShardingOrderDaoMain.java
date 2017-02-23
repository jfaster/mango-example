package org.jfaster.mango.example.sharding;

import com.google.common.collect.Lists;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.Sharding;
import org.jfaster.mango.annotation.TableShardingBy;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.example.util.RandomUtils;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.sharding.TableShardingStrategy;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author ash
 */
public class TableShardingOrderDaoMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds);
        TableShardingOrderDao orderDao = mango.create(TableShardingOrderDao.class);

        List<Integer> uids = Lists.newArrayList(1, 2, 10010, 10086);
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

    @DB(table = "t_order")
    @Sharding(tableShardingStrategy = OrderTableShardingStrategy.class)
    public interface TableShardingOrderDao {

        @SQL("insert into #table(id, uid, price, status) values(:id, :uid, :price, :status)")
        public void addOrder(@TableShardingBy("uid") Order order);

        @SQL("select id, uid, price, status from #table where uid = :1")
        public List<Order> getOrdersByUid(@TableShardingBy int uid);

    }

    static class OrderTableShardingStrategy implements TableShardingStrategy<Integer> {

        @Override
        public String getTargetTable(String table, Integer uid) {
            int num = uid <= 1000 ? 0 : 1;
            return table + "_" + num;
        }

    }

}
