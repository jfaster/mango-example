package org.jfaster.mango.example.page;

import org.jfaster.mango.page.Direction;
import org.jfaster.mango.page.Order;
import org.jfaster.mango.page.Sort;

public class SortMain {

  public static void main(String[] args) {

    // 等价于 order by id asc
    Sort.by("id");

    // 等价于 order by id desc
    Sort.by(Direction.DESC, "id");

    // 等价于 order by id asc, name asc
    Sort.by("id", "name");

    // 等价于 order by id asc, name desc
    Sort.by(Order.by("id"), Order.desc("name"));
  }

}
