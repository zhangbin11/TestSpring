package prs.concurrent.c5;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangbin on 2017/7/12.
 */
public class TestCountDownLatch {

    private Integer taskCount = 10;

    private CountDownLatch startGate = new CountDownLatch(1);
    private CountDownLatch endGate = new CountDownLatch(taskCount);

    public void test(){

        for(int i=0;i<taskCount;i++){

            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        System.out.println("任务" + finalI + "开始执行");
                        Thread.sleep(1000l);
                        endGate.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        long start = System.currentTimeMillis();
        System.out.println("准备完成 开始执行");
        startGate.countDown();
        try {
            endGate.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        double sed = (end-start)/1000;

        System.out.println("一共运行了"+sed +"秒");

    }

    public static void main(String[] args) {
        TestCountDownLatch test = new TestCountDownLatch();
        test.test();
    }

}
