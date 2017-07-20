package prs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import prs.it.MindReader;
import prs.it.Thinker;

public class TestMindReader {
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
		Thinker t = (Thinker) ac.getBean("volunteer");
		t.thinkOfSomeThing("我饿了，想吃饭，其实我不想思考");
		MindReader m = (MindReader) ac.getBean("magician");
		System.out.println("-----------"+m.getThoughts());
	}

}
