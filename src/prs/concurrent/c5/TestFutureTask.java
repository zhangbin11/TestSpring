package prs.concurrent.c5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zhangbin on 2017/7/12.
 */
public class TestFutureTask {

    public static void main(String[] args) {
        FutureTask<String> result = new FutureTask<String>(new Callable<String>(){
            @Override
            public String call() throws Exception {
                Thread.sleep(5000l);
                return "完成了";
            }
        });
        new Thread(result).start();
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
