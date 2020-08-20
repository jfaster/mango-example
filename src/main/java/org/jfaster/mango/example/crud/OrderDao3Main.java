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
public class OrderDao3Main {

  public static void main(String[] args) {
    String driverClassName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/mango_example";
    String username = "root"; // 这里请使用您自己的用户名
    String password = "root"; // 这里请使用您自己的密码
    DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
    Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

    Order3Dao dao = mango.create(Order3Dao.class);
    Order3 order3 = new Order3();
    String orderId = RandomUtils.randomStringId(10);
    order3.setOrderId(orderId);
    order3.setUid(100);
    order3.setStatus(1);
    dao.add(order3);
    System.out.println(dao.getOne(orderId));
    order3.setStatus(2);
    dao.update(order3);
    System.out.println(dao.getOne(orderId));
  }

  @DB(table = "t_order3")
  interface Order3Dao extends CrudDao<Order3, String> {
  }

}
