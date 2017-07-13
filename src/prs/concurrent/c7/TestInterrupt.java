package prs.concurrent.c7;

/**
 * Created by zhangbin on 2017/7/13.
 */
public class TestInterrupt extends Thread {
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
//                    try {
                        System.out.println("-----------------");
//                        Thread.sleep(1000l);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }

    }

    public void cancel(){
        interrupt();
    }

    public static void main(String[] args) {
        TestInterrupt t = new TestInterrupt();
        t.start();
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.cancel();
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(!Thread.currentThread().isInterrupted()){
//                    try {
//                        System.out.println("-----------------");
//                        Thread.sleep(1000l);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        t.start();
//        try {
//            Thread.sleep(3000l);
//            t.interrupt();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
