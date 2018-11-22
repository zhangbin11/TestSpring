package prs.corejava.thread;

/**
 * Created by zhangbin on 2017/7/5.
 */
public class TestBack implements Runnable {

    private Bank bank;

    private int fromAccount;
    private double maxAmount;

    public TestBack(Bank bank,int from , double max){
        this.bank = bank;
        fromAccount = from;
        maxAmount = max;
    }

    @Override
    public void run() {

        while (true){
            int toAccount = (int)(bank.size()*Math.random());
            double amount = maxAmount *Math.random();
            bank.transfer(fromAccount,toAccount,amount);
            try {
                Thread.sleep(5000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Bank b = new Bank();
        for(int i=0;i<10;i++){
            Thread t = new Thread(new TestBack(b, i, 100.00));
            t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
            t.start();
        }
    }
}
