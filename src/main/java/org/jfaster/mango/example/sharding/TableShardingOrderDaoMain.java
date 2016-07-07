package org.jfaster.mango.example.sharding;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.example.util.RandomUtils;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;

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

        for (int uid = 1; uid <= 4; uid++) {
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

}
