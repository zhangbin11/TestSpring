package prs.corejava.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by zhangbin on 2017/7/24.
 */
public class SocketTest {

    public static void main(String[] args) {
        Socket sk = null;
        try {
            sk = new Socket("time-A.timefreq.bldrdoc.gov",13);
            InputStream is = sk.getInputStream();
            Scanner s = new Scanner(is);
            while(s.hasNextLine()){
                String line = s.nextLine();
                System.out.println(line+"--");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sk!=null){
                try {
                    sk.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
