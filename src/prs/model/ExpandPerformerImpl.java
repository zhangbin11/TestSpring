package prs.model;

import prs.it.ExpandPerformer;
import prs.it.Performer;

public class ExpandPerformerImpl implements ExpandPerformer {

	
	public void expandMethod() {
		System.out.println("perform的扩展方法1");
	}

	@Override
	public void expand() {
		System.out.println("perform的扩展方法2");
		
	}

}
