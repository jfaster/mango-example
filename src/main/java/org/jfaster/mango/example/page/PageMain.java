package org.jfaster.mango.example.page;

import org.jfaster.mango.page.Direction;
import org.jfaster.mango.page.Order;
import org.jfaster.mango.page.Page;
import org.jfaster.mango.page.Sort;

public class PageMain {

  public static void main(String[] args) {

    int pageNum = 1;
    int pageSize = 10;

    // 等价于 limit pageNum * pageSize, pageSize
    Page.of(pageNum, pageSize);

    // 等价于 order by id desc limit pageNum * pageSize, pageSize
    Page.of(pageNum, pageSize, Direction.DESC, "id");

    // 等价于 order by id asc, name desc limit pageNum * pageSize, pageSize
    Page.of(pageNum, pageSize, Sort.by(Order.by("id"), Order.desc("name")));
  }

}
