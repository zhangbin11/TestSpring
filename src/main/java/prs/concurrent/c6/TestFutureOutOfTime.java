package prs.concurrent.c6;

import java.util.concurrent.*;

/**
 * Created by zhangbin on 2017/7/13.
 */
public class TestFutureOutOfTime {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        Future<Integer> f1 = executorService.submit(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                Thread.sleep(3000l);
//                return 1;
//            }
//        });
//        try {
//            f1.get(1, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }

        FutureTask<Integer> f2 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000l);
                return 1;
            }
        });

        new Thread(f2).start();
        try {
            f2.get(1,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
