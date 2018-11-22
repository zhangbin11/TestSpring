package prs.concurrent.c6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by zhangbin on 2017/7/13.
 */
public class TestInvokeAll {

    public static void main(String[] args) {
        List<Future<Integer>> list ;
        List<Callable<Integer>> cl = new ArrayList<>();
        for(int i =0;i<10 ;i++){
            cl.add(new Task(i));
        }
        ExecutorService e = Executors.newFixedThreadPool(5);
        try {
            list = e.invokeAll(cl,2, TimeUnit.SECONDS);
            for(Future<Integer> f : list){
                try {
                System.out.println(f.get());
                } catch (Exception e0) {
                    e0.printStackTrace();
                }
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        e.shutdown();
    }

}

class Task implements Callable<Integer>{
    private Integer i;
    public Task(Integer i){
        this.i = i ;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000l);
        return i*2;
    }
}
