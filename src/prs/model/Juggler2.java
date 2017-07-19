package prs.model;

import prs.it.Performer2;

public class Juggler2 implements Performer2{

	@Override
	public void perform() {
		System.out.println("演奏了一曲<<产品经理是条狗>>");
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
