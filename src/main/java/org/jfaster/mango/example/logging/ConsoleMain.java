package org.jfaster.mango.example.logging;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.util.logging.MangoLogger;

import javax.sql.DataSource;

/**
 * @author ash
 */
public class ConsoleMain {

    public static void main(String[] args) {
        MangoLogger.useConsoleLogger(); // 使用System.out输出日志

        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

        FruitDao dao = mango.create(FruitDao.class);
        String name = "apple";
        int num = 7;
        dao.add(name, num);
    }

    @DB
    interface FruitDao {

        // 插入数据
        @SQL("insert into fruit(name, num) values(:1, :2)")
        public void add(String name, int num);

        // 根据name取num的总和
        @SQL("select sum(num) from fruit where name=:1")
        public int getTotalNum(String name);

    }

}
