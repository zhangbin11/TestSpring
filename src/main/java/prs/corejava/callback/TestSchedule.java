package prs.corejava.callback;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangbin on 2018/6/5.
 */
public class TestSchedule {

    public static void main(String[] args) {
        ScheduledExecutorService se = Executors.newScheduledThreadPool(25, new NameThreadFactory("set_pos_thread"));
        final int[] i = {0};
//        se.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("time : "+ new Date());
//                try {
//                    Thread.sleep(2000l);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, 0, 1000, TimeUnit.MILLISECONDS);

        se.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("time : "+ new Date());
                try {
                    Thread.sleep(2000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);

//        se.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("time : "+ new Date());
//                try {
//                    Thread.sleep(2000l);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },1000, TimeUnit.MILLISECONDS);

        try {
            Thread.sleep(60000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
