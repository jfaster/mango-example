package org.jfaster.mango.example.sharding;

import com.google.common.collect.Lists;
import org.jfaster.mango.datasource.DataSourceFactory;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.datasource.SimpleDataSourceFactory;
import org.jfaster.mango.example.util.RandomUtils;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author ash
 */
public class ShardingOrder3DaoMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码

        String url1 = "jdbc:mysql://localhost:3306/mango_example_db1";
        DataSource ds1 = new DriverManagerDataSource(driverClassName, url1, username, password);
        DataSourceFactory db1DataSourceFactory = new SimpleDataSourceFactory("db1", ds1);

        String url2 = "jdbc:mysql://localhost:3306/mango_example_db2";
        DataSource ds2 = new DriverManagerDataSource(driverClassName, url2, username, password);
        DataSourceFactory db2DataSourceFactory = new SimpleDataSourceFactory("db2", ds2);

        Mango mango = Mango.newInstance(db1DataSourceFactory, db2DataSourceFactory);

        ShardingOrder3Dao orderDao = mango.create(ShardingOrder3Dao.class);

        List<Integer> uids = Lists.newArrayList(66, 67, 9527, 9528);
        for (Integer uid : uids) {
            String randomId = RandomUtils.randomStringId(10); // 随机生成10位字符串ID
            String databaseMark = uid < 1000 ? "1" : "2";
            String tableMark = uid % 2 + "";
            String id = databaseMark + tableMark + randomId; // ID前添加分库分表标记
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

}
