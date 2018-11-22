package prs.concurrent.c3;

/**
 * Created by zhangbin on 2017/7/10.
 */
public class NoVisibility {


    private static boolean ready;
    private static Integer number;

    private static class ReadThread extends Thread{
        @Override
        public void run() {
            while(!ready){
                Thread.yield();
            }
            System.out.println("number is "+number );
        }
    }

    public static void main(String[] args) {
        //线程不同步导致结果的错误，有可能一直循环下去，有可能输出0
        new ReadThread().start();
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number = 4;
        ready = true;
    }
}
