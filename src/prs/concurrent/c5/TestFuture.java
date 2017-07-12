package prs.concurrent.c5;

import java.util.concurrent.*;

/**
 * Created by zhangbin on 2017/7/12.
 */
public class TestFuture {

    public static void main(String[] args) {
        ExecutorService exe = Executors.newSingleThreadExecutor();
        Future<String> result = exe.submit(new Callable<String>(){
            @Override
            public String call() throws Exception {
                Thread.sleep(5000l);
                return "完成了";
            }
        });
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        exe.shutdown();
    }

}
