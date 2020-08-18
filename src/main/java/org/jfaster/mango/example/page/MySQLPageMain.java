package org.jfaster.mango.example.page;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.page.*;

import javax.sql.DataSource;
import java.util.List;

public class MySQLPageMain {

  public static void main(String[] args) {
    String driverClassName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/mango_example";
    String username = "root"; // 这里请使用您自己的用户名
    String password = "root"; // 这里请使用您自己的密码
    DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
    Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

    MessageDao dao = mango.create(MessageDao.class);
    dao.deleteAll();
    int uid = 100;
    for (int i = 0; i < 10; i++) {
      Message msg = new Message();
      msg.setUid(uid);
      msg.setContent(i + 1);
      dao.insert(msg);
    }

    int pageNum = 2;
    int pageSize = 3;

    // 等价于 order by id desc
    Sort sort = Sort.by(Direction.DESC, "id");
    List<Message> msgs = dao.getMessages(uid, sort);
    System.out.println("msgs: " + msgs);

    // 等价于 limit pgeNum * pageSize, pageSize
    Page page = Page.of(pageNum, pageSize);
    msgs = dao.getMessages(uid, page);
    System.out.println("msgs: " + msgs);

    // 等价于 order by id desc limit pgeNum * pageSize, pageSize
    page = Page.of(pageNum, pageSize, Sort.by(Direction.DESC, "id"));
    msgs = dao.getMessages(uid, page);
    System.out.println("msgs: " + msgs);
  }

  @DB
  interface MessageDao {

    @ReturnGeneratedId
    @SQL("insert into message(uid, content) values(:uid, :content)")
    int insert(Message msg);

    @SQL("select id, uid, content from message where uid=:1")
    List<Message> getMessages(int uid, Sort sort);

    @SQL("select id, uid, content from message where uid=:1")
    List<Message> getMessages(int uid, Page page);

    @SQL("delete from message")
    void deleteAll();

  }

}
