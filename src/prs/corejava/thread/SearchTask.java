package prs.corejava.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhangbin on 2017/7/6.
 */
public class SearchTask implements Runnable{


    private BlockingQueue queue;

    private String keyword;

    public SearchTask(BlockingQueue queue,String keyword){
        this.queue = queue;
        this.keyword = keyword;
    }

    @Override
    public void run() {
        boolean done = false;

        while(!done){
            File f = null;
            try {
                f = (File) queue.take();
                if(f == FileEnumerationTask.EmptyFile){
                    queue.put(f);
                    done = true;
                }else{
                    searchFile(f);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void searchFile(File f){
        try(Scanner in = new Scanner(f)){
            int lineNumber = 0;
            while (in.hasNextLine()){
                lineNumber++;
                String line = in.nextLine();
                if(line.contains(keyword)){
                    System.out.println("f = [" + f.getPath() + "],linenumber"+lineNumber+" "+line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
