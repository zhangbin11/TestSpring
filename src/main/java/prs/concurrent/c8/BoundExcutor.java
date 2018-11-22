package prs.concurrent.c8;

import java.util.concurrent.*;

/**
 * Created by zhangbin on 2017/7/14.
 */
public class BoundExcutor {

    private final Executor executor;
    private final Semaphore sem;

    public BoundExcutor(Executor executor,Integer bound){
        this.executor = executor;
        sem = new Semaphore(bound);
    }

    public void submit(final Runnable runnable) throws InterruptedException {
        sem.acquire();
        try {

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        runnable.run();
                    }finally {
                        sem.release();
                    }
                }
            });
        }catch (RejectedExecutionException re){
            System.out.println("runnable = [" + runnable + "]");
            sem.release();
        }

    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,5,0l, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        BoundExcutor be = new BoundExcutor(executor,3);
        try {
            be.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("测试1");
                }
            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
