package prs.corejava.jvm.c2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangbin on 2017/8/7.
 */
public class HeapOOM {

    //vm args : -Xms2m -Xmx2m -XX:+HeapDumpOnOutOfMemoryError

    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while(true){
            list.add(new OOMObject());
        }
    }
}
