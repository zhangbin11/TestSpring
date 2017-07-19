package prs.corejava.thread;

/**
 * Created by zhangbin on 2017/7/5.
 */
public class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("threadname: "+t.getName());
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
}
