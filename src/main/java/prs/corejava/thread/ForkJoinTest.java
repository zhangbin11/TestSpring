package prs.corejava.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by zhangbin on 2017/7/7.
 */
public class ForkJoinTest {

    public static void main(String[] args) {
        int size = 10000000;
        double[] numbers = new double[size];
        for(int i=0;i<size;i++){
            numbers[i]=Math.random();
        }

        Counter counter = new Counter(numbers, 0, size, new Filter() {
            @Override
            public boolean accept(double t) {
                return t>0.5;
            }
        });
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }
}

interface Filter{
    boolean accept(double t);
}

class Counter extends RecursiveTask<Integer>{

    public static final int TRESHOLD = 1000;

    private double[] values;
    private int from;
    private int to;
    private Filter filter;

    public Counter(double[] values,int from,int to,Filter filter){
        this.values = values;
        this.filter = filter;
        this.from = from;
        this.to = to;
    }


    @Override
    protected Integer compute() {

        if(to -from < TRESHOLD){
            int count = 0;
            for(int i=from;i<to;i++){
                if(filter.accept(values[i])){
                    count++;
                }
            }
            return count;
        }else{
            int mid = (from+to)/2;
            Counter first = new Counter(values,from,mid,filter);
            Counter second = new Counter(values,mid,to,filter);
            invokeAll(first,second);
            return first.join() + second.join();
        }
    }
}
