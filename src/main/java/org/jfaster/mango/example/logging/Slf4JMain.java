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
public class Slf4JMain {

    /**
     * !!!
     * 为了避免工程中其他示例代码输出debug信息，影响显示输出结果
     * resources目录下logback.xml文件中logger的level被设置成了error
     * 运行此代码时，请将logback.xml文件中logger的level从error改为debug
     * !!!
     */
    public static void main(String[] args) {
        MangoLogger.useSlf4JLogger(); // 使用slf4j输出日志，logback.xml文件在resources目录下

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
