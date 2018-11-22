package prs.corejava.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by zhangbin on 2017/7/24.
 */
public class SocketServerThread implements Runnable {

    private Socket s;

    public SocketServerThread( Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        InputStream is = null;
        try {
            is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            Scanner sc = new Scanner(is);
            PrintWriter pw = new PrintWriter(os,true);
            pw.write("hello,print bye to exit");
            boolean done = false;
            while(!done && sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
                pw.println("echo:"+line);
                if(line!=null && line.toLowerCase().equals("bye")){
                    done = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(s!=null){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
