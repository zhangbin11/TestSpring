package prs.c5.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import prs.c5.it.BeanWithAnnotation;
import prs.it.Performer;

@Component("testA")
public class BeanWithAnnotationImpl implements BeanWithAnnotation {

	@Resource(name="duke")
	private Performer duke;
	
	public void perform() {
		duke.perform();
	}
}
