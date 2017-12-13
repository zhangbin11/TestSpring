package prs.corejava.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Created by zhangbin on 2017/9/25.
 */
public class TestProcess {

    public static void main(String[] args) {

        String cmd = "pwd";
        Runtime runtime = Runtime.getRuntime();
        try {
            Process p = runtime.exec(cmd);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s;
            while((s=bufferedReader.readLine()) != null)
                System.out.println(s);
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
