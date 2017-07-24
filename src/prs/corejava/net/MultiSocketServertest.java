package prs.corejava.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhangbin on 2017/7/24.
 */
public class MultiSocketServertest {

    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(8189);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            try {
                Socket s = ss.accept();
                System.out.println("接入了一个新的socket");
                new Thread(new SocketServerThread(s)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
