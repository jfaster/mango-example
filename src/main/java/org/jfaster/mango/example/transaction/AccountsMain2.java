package org.jfaster.mango.example.transaction;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.transaction.*;

import javax.sql.DataSource;

public class AccountsMain2 {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds);

        final AccountsDao dao = mango.create(AccountsDao.class);

        final int zhangsan = 1;
        final int lisi = 2;
        final int money = 100;

        if (dao.getAccount(zhangsan) == null) {
            dao.addAccount(zhangsan, 10000);
        }
        if (dao.getAccount(lisi) == null) {
            dao.addAccount(lisi, 10000);
        }

        TransactionTemplate.execute(new TransactionAction() {

            @Override
            public void doInTransaction(TransactionStatus status) {
                dao.transferMoney(zhangsan, -money);
                dao.transferMoney(lisi, money);
            }
        });

    }

}
