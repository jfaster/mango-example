package org.jfaster.mango.example.transaction;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.transaction.Transaction;
import org.jfaster.mango.transaction.TransactionFactory;

import javax.sql.DataSource;

public class AccountsDaoRunner {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds);

        AccountsDao dao = mango.create(AccountsDao.class);

        int zhangsan = 1;
        int lisi = 2;
        int money = 100;

        Transaction tx = TransactionFactory.newTransaction();
        try {
            dao.addMoney(zhangsan, -money);
            dao.addMoney(lisi, money);
            tx.commit();
        } catch (Throwable e) {
            tx.rollback();
        }
    }


}
