package prs.corejava.thread;

/**
 * Created by zhangbin on 2017/7/5.
 */
public class TestUncaughtExceptionHandler  implements Runnable {
    @Override
    public void run() {
        int i = 12/0;
    }

    public static void main(String[] args) {
        Thread t = new Thread(new TestUncaughtExceptionHandler());
        t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        t.start();
    }
}
