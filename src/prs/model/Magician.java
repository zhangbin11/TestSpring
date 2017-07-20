package prs.model;

import prs.it.MindReader;

public class Magician implements MindReader{
	
	private String toughts;

	@Override
	public void interceptThoughts(String thoughts) {
		System.out.println("拦截到想法。。。。。"+thoughts);
		this.toughts = thoughts;
	}

	@Override
	public String getThoughts() {
		return toughts;
	}

}
