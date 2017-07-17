package prs.concurrent.c13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangbin on 2017/7/17.
 */
public class TestTryLock {

    private Lock lock = new ReentrantLock();


    public void m1(){
        try {
            while (true){
                if(lock.tryLock()){
                    System.out.println(Thread.currentThread().getName() + "----获得锁成功");
                    Thread.sleep(10000l);
                    return;
                }else{
                    System.out.println(Thread.currentThread().getName()+"----获取锁失败");
                    Thread.sleep(5000l);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }



    public static void main(String[] args) {
        TestTryLock l = new TestTryLock();
        new Thread(new TestThread(l)).start();
        new Thread(new TestThread(l)).start();
        new Thread(new TestThread(l)).start();
        new Thread(new TestThread(l)).start();


    }
}

class TestThread implements Runnable{

    private TestTryLock testTryLock = null;

    public TestThread(TestTryLock testTryLock){
        this.testTryLock = testTryLock;
    }
    @Override
    public void run() {
        testTryLock.m1();
    }
}