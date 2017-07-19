package prs.corejava.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhangbin on 2017/7/5.
 */
public class TestCollectionView {

    public static void main(String[] args) {
        Collections.synchronizedCollection(new ArrayList<>());
        List<Integer> l2 = new ArrayList<>();
        //设置为不可变
        Collection<Integer> c =  Collections.unmodifiableCollection(l2);
//        c.add(1);

        for(int i=0;i<10;i++){
            l2.add(i);
        }

        List<Integer> l3 = l2.subList(0,4);
        l3.add(6);
        l3.set(0,7);
        l3.remove(4);
    }

}
