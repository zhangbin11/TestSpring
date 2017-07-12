package prs.concurrent.c5;

import java.util.concurrent.Semaphore;

/**
 * Created by zhangbin on 2017/7/12.
 */
public class TestSemaphore {

    private Integer count = 5;

    private Semaphore semaphore = new Semaphore(count);

    public void test(){

        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "-----请求执行");
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "-----开始执行");
                        Thread.sleep(3000l);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        TestSemaphore test = new TestSemaphore();
        test.test();
    }

}
