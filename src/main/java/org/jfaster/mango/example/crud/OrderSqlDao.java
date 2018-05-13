package org.jfaster.mango.example.crud;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.crud.CrudDao;

import java.util.List;

/**
 * @author ash
 */
@DB(table = "t_order")
public interface OrderSqlDao {

  @SQL("select id, uid, status from #table where id = :1")
  Order findById(int id);

  @SQL("select id, uid, status from #table where uid = :1")
  List<Order> findByUid(int uid);

  @SQL("select id, uid, status from #table where id = :1 and uid = :2")
  Order findByIdAndUid(int id, int uid);

  @SQL("select id, uid, status from #table where id = :1 or uid = :2")
  Order findByIdOrUid(int id, int uid);

  @SQL("select count(1) from #table where uid = :1")
  int countByUid(int uid);

  @SQL("delete from #table where uid = :1")
  int deleteByUid(int uid);

}
