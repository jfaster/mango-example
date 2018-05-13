package org.jfaster.mango.example.crud;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.crud.CrudDao;
import org.jfaster.mango.plugin.page.Page;

import java.util.List;

/**
 * @author ash
 */
@DB(table = "t_order")
public interface OrderPageNoSqlDao extends CrudDao<Order, Integer> {

  List<Order> findByUid(int uid, Page page);

  List<Order> findByIdOrUid(int id, int uid, Page page);

}
