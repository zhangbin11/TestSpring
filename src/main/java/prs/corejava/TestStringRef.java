package prs.corejava;

/**
 * Created by zhangbin on 2017/6/28.
 */
public class TestStringRef {


    public static void mA(String s ){
        s="ssssss";
        System.out.println(s);
    }

    public static void mB(Integer i){
        i=2;
        System.out.println("i = [" + i + "]");
    }



    public static void main(String[] args) {
        String s = "aaaaaa";
        System.out.println(s);
        mA(s);
        System.out.println(s);

        Integer i = 1;
        System.out.println("args = [" + i + "]");
        mB(i);
        System.out.println("args = [" + i + "]");
    }
}
