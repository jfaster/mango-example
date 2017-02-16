package org.jfaster.mango.example.spring;

import org.jfaster.mango.operator.Mango;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ash
 */
public class MultipleMain {

    public static void main(String[] args) {
        String configLocation = "org/jfaster/mango/example/spring/applicationContext-multiple.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
        System.out.println(ctx.getBean(UserDao.class) != null);
        System.out.println(ctx.getBean(StudentDao.class) != null);

        Mango mango = ctx.getBean(Mango.class);
        System.out.println(mango);
    }

}
