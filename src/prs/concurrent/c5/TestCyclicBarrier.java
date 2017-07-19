package prs.concurrent.c5;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by zhangbin on 2017/7/12.
 */
public class TestCyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("到齐了");
            }
        });

        for(int i=0;i<5;i++){
            new Thread(new Roommate(barrier)).start();
        }
    }
}
