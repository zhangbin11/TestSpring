package prs.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import prs.it.Performer;

/**
 * Created by zhangbin on 2017/6/27.
 */
public class TestAudience {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Performer p = (Performer) ac.getBean("kenny");
        p.perform();
    }
}
