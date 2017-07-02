package prs.corejava.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by zhangbin on 2017/6/30.
 */
public class UseReflectionToCopyArray {


    public static Object copyArray(Object a){
        Object newarray = null;
        Class cl = a.getClass();
        if (! cl.isArray()) return null;
        int length = Array.getLength(a);
        Class componetCl = cl.getComponentType();
        newarray = Array.newInstance(componetCl,length);
        System.arraycopy(a,0,newarray,0,length);
        return newarray;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = (int[]) copyArray(a);
        System.out.println(Arrays.toString(b));
    }

}
