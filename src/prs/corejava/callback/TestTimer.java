package prs.corejava.callback;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by zhangbin on 2017/6/30.
 */
public class TestTimer {
    public static void main(String[] args) {
        ActionListener al = new TimePrinter();

        Timer t = new Timer(10000,al);
        t.start();

        try {
            Thread.sleep(20000);
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