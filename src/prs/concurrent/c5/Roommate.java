package prs.concurrent.c5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by zhangbin on 2017/7/12.
 */
public class Roommate implements Runnable{

    private CyclicBarrier cyclicBarrier;

    public Roommate(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        try {

            System.out.println(Thread.currentThread().getName() + "开始出发，等待其他人到");
            Thread.sleep(2000l);
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":开吃");

    }
}
