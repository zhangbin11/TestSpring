package prs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import prs.it.Performer;

/**
 * Created by zhangbin on 2017/6/12.
 */
public class TestJuggler {

    public static void  main(String[] args){
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
//        Performer pf = (Performer) ac.getBean("duke");
//        pf.perform();
        System.out.print(System.currentTimeMillis());
    }
}
