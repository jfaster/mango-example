package org.jfaster.mango.example.stat;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.stat.OperatorStat;
import org.jfaster.mango.stat.StatMonitor;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ash
 */
public class StatOut {

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
                StringBuilder data = new StringBuilder();
                data.append("Performance Statistics  [")
                        .append(format(statBeginTime))
                        .append("] - [")
                        .append(format(statEndTime))
                        .append("]")
                        .append("\n");
                data.append(String.format("%-36s%-12s%-12s%-12s%n",
                        "dao", "avg", "total", "error"));
                for (OperatorStat stat : stats) {
                    if (stat.getDatabaseExecuteCount() > 0) { // 执行db数大于0才统计
                        String dao = stat.getMethod().getDeclaringClass().getSimpleName() + "." + stat.getMethod().getName();
                        data.append(String.format("%-36s%-12.1f%-12s%-12s%n",
                                dao,
                                (double) stat.getDatabaseExecuteAveragePenalty() / (1000*1000),
                                stat.getDatabaseExecuteCount(),
                                stat.getDatabaseExecuteExceptionCount()));
                    }
                }
                System.out.println(data);
            }

            @Override
            public int periodSecond() {
                return 10;
            }

            private String format(long time) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return format.format(new Date(time));
            }

        });

        // 后续创建DAO，执行DAO的代码
    }

}
