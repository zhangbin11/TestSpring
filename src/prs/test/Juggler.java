package prs.test;

import prs.it.Performer;

/**
 * Created by zhangbin on 2017/6/12.
 */
public class Juggler implements Performer {

    private int beanBags = 3;


    public  Juggler(){};

    public  Juggler(int beanBags){
        this.beanBags = beanBags;
    }

    @Override
    public void perform() {
        System.out.print("Guggling "+beanBags +" beanBags");
    }
}
