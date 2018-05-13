package org.jfaster.mango.example.crud;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;

/**
 * @author ash
 */
public class OrderDaoMain {

  public static void main(String[] args) {
    String driverClassName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/mango_example";
    String username = "root"; // 这里请使用您自己的用户名
    String password = "root"; // 这里请使用您自己的密码
    DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
    Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

    OrderNoSqlDao dao = mango.create(OrderNoSqlDao.class);
    Order order = new Order();
    order.setUid(100);
    order.setStatus(1);
    dao.add(order);
    int id = dao.addAndReturnGeneratedId(order);
    order.setId(id);
    System.out.println(dao.getOne(id));
    order.setStatus(2);
    dao.update(order);
    System.out.println(dao.getOne(id));
  }

}
