package prs.corejava.thread;

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


    public Bank(){

            accounts = new Double[10];
            for (int i = 0; i < accounts.length; i++) {
                accounts[i] = 10000.00;
            }

    }

    public void transfer(int from,int to ,double amount){
        lock.lock();
        try {
            if (accounts[from] < amount) {
                return;
            }
            accounts[from] -= amount;
            accounts[to] += amount;
        } finally {
            lock.unlock();
        }
    }

}
