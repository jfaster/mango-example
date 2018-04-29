package org.jfaster.mango.example.crud;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.crud.CrudDao;

/**
 * @author ash
 */
@DB(table = "t_order")
public interface OrderDao extends CrudDao<Order, Integer> {

  Order findByIdAndUid(int id, int uid);

}
