package prs.corejava.collection;

import prs.corejava.generic.Pair;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangbin on 2017/7/5.
 */
public class TestArrays {
    public static void main(String[] args) {
        Pair[] ps = new Pair[10];
        List<Pair> plst = Arrays.asList(ps);
        plst.add(new Pair());
        //plst为一个视图对象 包含最基本的set和get方法 并不能改变数组
//        plst.set(1,new Pair());
//        plst.add(new Pair());

    }
}
