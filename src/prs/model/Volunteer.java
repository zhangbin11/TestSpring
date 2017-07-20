package prs.model;

import prs.it.Thinker;

public class Volunteer implements Thinker{

	@Override
	public void thinkOfSomeThing(String thoughts) {
		System.out.println(thoughts);
	}

}
