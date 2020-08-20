package org.jfaster.mango.example.crud;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.crud.CrudDao;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.example.util.RandomUtils;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;

/**
 * @author ash
 */
public class OrderDao2Main {

  public static void main(String[] args) {
    String driverClassName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/mango_example";
    String username = "root"; // 这里请使用您自己的用户名
    String password = "root"; // 这里请使用您自己的密码
    DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
    Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

    Order2Dao dao = mango.create(Order2Dao.class);
    Order2 order2 = new Order2();
    String orderId = RandomUtils.randomStringId(10);
    order2.setOrderId(orderId);
    order2.setUid(100);
    order2.setStatus(1);
    dao.add(order2);
    System.out.println(dao.getOne(orderId));
    order2.setStatus(2);
    dao.update(order2);
    System.out.println(dao.getOne(orderId));
  }

  @DB(table = "t_order2")
  interface Order2Dao extends CrudDao<Order2, String> {
  }

}
