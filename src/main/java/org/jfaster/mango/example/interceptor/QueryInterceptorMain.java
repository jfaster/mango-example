package org.jfaster.mango.example.interceptor;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.binding.BoundSql;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.interceptor.Parameter;
import org.jfaster.mango.interceptor.QueryInterceptor;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author ash
 */
public class QueryInterceptorMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

        mango.addInterceptor(new MyQueryInterceptor());

        MessageDao dao = mango.create(MessageDao.class);
        int uid = 100;
        Message msg = new Message();
        msg.setUid(uid);
        msg.setContent("hello");

        dao.insert(msg);
        dao.getMessages(uid);
    }

    static class MyQueryInterceptor extends QueryInterceptor {

        public void interceptQuery(
                BoundSql boundSql,
                List<Parameter> parameters,
                DataSource dataSource) {

            System.out.println("sql: " + boundSql.getSql());
            System.out.println("args: " + boundSql.getArgs());
        }

    }

    @DB
    interface MessageDao {

        @ReturnGeneratedId
        @SQL("insert into message(uid, content) values(:uid, :content)")
        public int insert(Message msg);

        @SQL("select id, uid, content from message where uid=:1")
        public List<Message> getMessages(int uid);

    }

}
