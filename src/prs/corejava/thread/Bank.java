package prs.corejava.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangbin on 2017/7/5.
 */
public class Bank {

    private Double[] accounts;

    public int size(){
        return accounts.length;
    }

    private Lock lock = new ReentrantLock();

    private Condition sufficientFunds;

    public Bank(){

            accounts = new Double[10];
            for (int i = 0; i < accounts.length; i++) {
                accounts[i] = 1000.00;
            }
        sufficientFunds=lock.newCondition();
    }

    public void transfer(int from,int to ,double amount){
        lock.lock();
        try {
            if (accounts[from] < amount) {
                System.out.println("账户:"+from+"没钱了，等待中");
                try {
                    sufficientFunds.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            accounts[from] -= amount;
            accounts[to] += amount;
            System.out.println("from = [" + from + "], to = [" + to + "], amount = [" + amount + "]");
            sufficientFunds.signal();
        } finally {
            lock.unlock();
        }
    }

}
