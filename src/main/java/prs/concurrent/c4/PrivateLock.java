package prs.concurrent.c4;

/**
 * Created by zhangbin on 2017/7/12.
 */
public class PrivateLock {

    private Object lock = new Object();

    public void m1(){
        synchronized (lock){
            System.out.println("私有锁");
        }
    }

}
