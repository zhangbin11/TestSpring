package prs.c5.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import prs.c5.it.BeanWithAnnotation;

public class TestAnnotation {
	
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
		BeanWithAnnotation ba = (BeanWithAnnotation) ac.getBean("testA");
		ba.perform();
	}
}
