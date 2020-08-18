package org.jfaster.mango.example.page;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.page.Direction;
import org.jfaster.mango.page.Page;
import org.jfaster.mango.page.PageResult;
import org.jfaster.mango.page.Sort;

import javax.sql.DataSource;
import java.util.List;

public class PageResultMain {

  public static void main(String[] args) {
  }

  @DB
  interface MessageDao {

    @SQL("select id, uid, content from message where uid=:1")
    List<Message> getMessages(int uid, Page page);

    @SQL("select id, uid, content from message where uid=:1")
    PageResult<Message> getMessagesWithTotal(int uid, Page page);

  }

}
