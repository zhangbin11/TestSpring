package prs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import prs.it.ExpandPerformer;
import prs.it.Performer;
import prs.model.ExpandPerformerImpl;

public class TestExpandPerformer {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
//		ExpandPerformerImpl el = (ExpandPerformerImpl) ac.getBean("eimpl");
//		el.expandMethod();
//		ExpandPerformer ep = (ExpandPerformer) ac.getBean("eimpl");
//		ep.expand();
//		Performer p = (Performer) ac.getBean("eimpl");
//		p.perform();
//		ExpandPerformerImpl el = (ExpandPerformerImpl) ac.getBean("duke");
//		el.expandMethod();
		ExpandPerformer ep = (ExpandPerformer) ac.getBean("duke");
		ep.expand();
		Performer p = (Performer) ac.getBean("duke");
		p.perform();
	}

}
