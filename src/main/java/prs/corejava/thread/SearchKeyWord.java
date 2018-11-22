package prs.corejava.thread;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhangbin on 2017/7/6.
 */
public class SearchKeyWord {

    public static void main(String[] args) {
        String keyword = "invoke";
        String directory = "/Users/bigbad/TestSpring";
        BlockingQueue<File> queue = new ArrayBlockingQueue<File>(100);

        FileEnumerationTask task = new FileEnumerationTask(queue,new File(directory));
        Thread t1 = new Thread(task);
        t1.start();
        for(int i=0;i<10;i++){
            new Thread(new SearchTask(queue,keyword)).start();
        }

    }
}
