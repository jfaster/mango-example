package org.jfaster.mango.example.transaction;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

@DB
public interface AccountsDao {

    @SQL("update accounts set money = money + :2 where uid = :1")
    boolean addMoney(int uid, int inc);

}
