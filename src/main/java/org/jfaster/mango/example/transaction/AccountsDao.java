package org.jfaster.mango.example.transaction;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

@DB
public interface AccountsDao {

    @SQL("update accounts set money = money + :2 where uid = :1")
    boolean transferMoney(int uid, int inc);

    @SQL("select uid, money from accounts where uid = :1")
    Account getAccount(int uid);

    @SQL("insert into accounts(uid, money) values(:1, :2)")
    void addAccount(int uid, int money);

}
