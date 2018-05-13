package org.jfaster.mango.example.crud;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.crud.CrudDao;

import java.util.List;

/**
 * @author ash
 */
@DB(table = "t_order")
public interface OrderNoSqlDao extends CrudDao<Order, Integer> {

  Order findById(int id);

  List<Order> findByUid(int uid);

  Order findByIdAndUid(int id, int uid);

  List<Order> findByIdOrUid(int id, int uid);

  int countByUid(int uid);

  int deleteByUid(int uid);

}
