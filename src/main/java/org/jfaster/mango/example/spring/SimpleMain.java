package org.jfaster.mango.example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ash
 */
public class SimpleMain {

    public static void main(String[] args) {
        String configLocation = "org/jfaster/mango/example/spring/applicationContext-simple.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
        System.out.println(ctx.getBean(UserDao.class) != null);
        System.out.println(ctx.getBean(StudentDao.class) != null);
    }

}
