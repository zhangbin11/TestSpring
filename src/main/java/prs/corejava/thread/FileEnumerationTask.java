package prs.corejava.thread;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhangbin on 2017/7/6.
 */
public class FileEnumerationTask implements Runnable{

    private BlockingQueue queue;

    private File startingDirectory;

    public static File EmptyFile = new File("");

    public FileEnumerationTask(BlockingQueue queue,File startingDirectory){
        this.queue = queue;
        this.startingDirectory = startingDirectory;
        try {
            queue.put(EmptyFile);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        addFileToQueue(startingDirectory);
    }


    private void addFileToQueue(File file){
        if( file != null){
            if(file.isDirectory()){
                for(File f : file.listFiles()){
                    addFileToQueue(f);
                }
            }else{
                try {
                    queue.put(file);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
