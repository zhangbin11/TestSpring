package prs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import prs.it.Performer2;

public class TestJuggler2 {
	
	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
		Performer2 p = (Performer2) ac.getBean("juggler2");
		p.perform();
	}
}
