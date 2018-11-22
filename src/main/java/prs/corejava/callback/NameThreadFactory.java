package prs.corejava.callback;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mc_luo on 2017/4/6.
 */
public class NameThreadFactory implements ThreadFactory {

    private String name;
    private static final AtomicInteger CREATE = new AtomicInteger();

    public NameThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread( Runnable r) {
        final int threadId = CREATE.incrementAndGet();
        Thread thread = new Thread(r, name + "_" + threadId);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                System.out.println("thread :" + thread.getName() + " error");
                ex.printStackTrace();
            }
        });
        return thread;
    }

    public static int getThreadCreateCount() {
        return CREATE.get();
    }
}

