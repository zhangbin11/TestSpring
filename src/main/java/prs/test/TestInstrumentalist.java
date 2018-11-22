package prs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangbin on 2017/6/16.
 */
public class TestInstrumentalist {

    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Instrumentalist ia = (Instrumentalist) ac.getBean("kenny");
        ia.perform();
    }

}
