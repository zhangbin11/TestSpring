package prs.c5.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import prs.c5.it.SpitterDao;
import prs.c5.model.Spitter;

public class TestSpitterDao {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
		SpitterDao dao = (SpitterDao) ac.getBean("spitterDao");
//		dao.insert("zhangSan", "123");
		
		Spitter r= dao.getById("41c626d8-c308-4783-a16d-34b4b35ce49e");
		System.out.println(r);
		
	}

}
