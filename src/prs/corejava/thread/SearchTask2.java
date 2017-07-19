package prs.corejava.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by zhangbin on 2017/7/6.
 */
public class SearchTask2 implements Callable<FileSearchResult> {


    private BlockingQueue queue;

    private String keyword;

    public SearchTask2(BlockingQueue queue,String keyword){
        this.queue = queue;
        this.keyword = keyword;
    }

    @Override
    public FileSearchResult call() throws Exception {

        boolean done = false;

        while(!done){
            File f = null;
            try {
                f = (File) queue.take();
                if(f == FileEnumerationTask.EmptyFile){
                    queue.put(f);
                    done = true;
                }else{
                    FileSearchResult r = searchFile(f);
                    if(r!=null){
                        return r;
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return new FileSearchResult();
    }


    private FileSearchResult searchFile(File f){
        try(Scanner in = new Scanner(f)){
            int lineNumber = 0;
            while (in.hasNextLine()){
                lineNumber++;
                String line = in.nextLine();
                if(line.contains(keyword)){
                    System.out.println("f = [" + f.getPath() + "],linenumber" + lineNumber + " " + line);
                    FileSearchResult r = new FileSearchResult();
                    r.setF(f);
                    r.setLine(line);
                    r.setLineNumber(lineNumber);
                    return  r;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String keyword = "invoke";
        String directory = "/Users/bigbad/TestSpring";
        BlockingQueue<File> queue = new ArrayBlockingQueue<File>(100);

        FileEnumerationTask task = new FileEnumerationTask(queue,new File(directory));
        Thread t1 = new Thread(task);
        t1.start();

        List<FutureTask<FileSearchResult>> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            FutureTask<FileSearchResult> f =new FutureTask( new SearchTask2(queue,keyword));
            list.add(f);
            Thread t = new Thread(f);
            t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
            t.start();
//            ExecutorService mExecutor = Executors.newSingleThreadExecutor();
//            mExecutor.submit(f);
        }
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(FutureTask<FileSearchResult> f : list) {
//            if (f.isDone()) {
                try {
                    System.out.println(f.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
//            }
        }

    }
}
