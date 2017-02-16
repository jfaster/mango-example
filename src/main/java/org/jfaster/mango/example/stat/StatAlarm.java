package org.jfaster.mango.example.stat;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.stat.OperatorStat;
import org.jfaster.mango.stat.StatMonitor;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ash
 */
public class StatAlarm {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

        mango.setStatMonitor(new StatMonitor() {

            @Override
            public void handleStat(long statBeginTime, long statEndTime, List<OperatorStat> stats) throws Exception {
                for (OperatorStat stat : stats) {
                    if (stat.getDatabaseExecuteAveragePenalty() > TimeUnit.MILLISECONDS.toNanos(10)) {
                        // 有DAO接口在10秒内平均响应时间大于10毫秒，促发短信或邮件报警
                        break;
                    }
                }
            }

            @Override
            public int periodSecond() {
                return 10;
            }

        });

        // 后续创建DAO，执行DAO的代码
    }

}
