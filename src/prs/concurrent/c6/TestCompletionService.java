package prs.concurrent.c6;

import java.util.concurrent.*;

/**
 * Created by zhangbin on 2017/7/13.
 */
public class TestCompletionService {

    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    public void test(){
        CompletionService<Integer> service = new ExecutorCompletionService<Integer>(executorService);

        for(int i=0;i<10;i++){
            final int fi = i;
            service.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return fi*2;
                }
            });
        }

        for(int i=0;i<10;i++){
            try {
                Future<Integer> f = service.take();
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        TestCompletionService s = new TestCompletionService();
        s.test();
    }

}
