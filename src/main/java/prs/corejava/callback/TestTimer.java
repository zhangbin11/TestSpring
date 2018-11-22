package prs.corejava.callback;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhangbin on 2017/6/30.
 */
public class TestTimer {
    public static void main(String[] args) {
        ActionListener al = new TimePrinter();

//        Timer t = new Timer(10000,al);
//        t.start();
//
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Timer t = new Timer(true);

        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("the time is " + new Date());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0,3000);

        try {
            Thread.sleep(3000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("the time is " + new Date());
    }
}