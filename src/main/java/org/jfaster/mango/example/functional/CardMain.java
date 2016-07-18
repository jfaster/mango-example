package org.jfaster.mango.example.functional;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;

/**
 * @author ash
 */
public class CardMain {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

        CardDao dao = mango.create(CardDao.class);
        Card card = new Card();
        String name = "ash";
        SubCard sc = new SubCard();
        sc.setType(10);
        sc.setContent("hello");
        card.setName(name);
        card.setSubCard(sc);
        int id = dao.addCard(card);
        Card cardFromDb = dao.getCardById(id);
        System.out.println("name=" + cardFromDb.getName());
        System.out.println("subCard.type=" + cardFromDb.getSubCard().getType());
        System.out.println("subCard.content=" + cardFromDb.getSubCard().getContent());
    }

}
