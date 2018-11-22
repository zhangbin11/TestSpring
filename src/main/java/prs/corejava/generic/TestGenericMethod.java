package prs.corejava.generic;

/**
 * Created by zhangbin on 2017/7/3.
 */
public class TestGenericMethod {

    public static void main(String[] args) {
        Integer[] as = {1,2,3};
        //多数情况下 调用方法时可以省略
        System.out.println(ArrayAlg.<Integer>getMiddle(as));
    }
}


class ArrayAlg{

    public static <T> T getMiddle(T... as){
        return as[as.length/2];
    }

}