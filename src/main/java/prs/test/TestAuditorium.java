package prs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangbin on 2017/6/15.
 */
public class TestAuditorium {

    public static void  main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Auditorium ad = (Auditorium) ac.getBean("auditorium");
        ((ClassPathXmlApplicationContext) ac).close();
    }
}
