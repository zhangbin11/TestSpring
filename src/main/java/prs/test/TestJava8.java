package prs.test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by zhangbin on 2017/8/23.
 */
public class TestJava8 {
    public  static Function<String,String> StoLower = (i)->i.toLowerCase();
    public  static Consumer<String> StoLowerC = (i)->{i=i.toLowerCase();};

    public static String m(String s,Predicate<String> predicate,Consumer<String> consumer){
        if(predicate.test(s)){
            System.out.println("s = [" + s + "]");
            consumer.accept(s);
        }
        return s;
    }

    public static void m3(String s,Predicate<String> predicate,Consumer<String> consumer){
        if(predicate.test(s)){
            System.out.println("s = [" + s + "]");
            consumer.accept(s);
        }
    }

    public static String m2(String s,Predicate<String> predicate,Function<String,String> function){
        if(predicate.test(s)){
            System.out.println("s = [" + s + "]");
            s = function.apply(s);
        }
        return s;
    }


    public static void main(String[] args) {
        String s = "AAAA";
//        s = m(s, String -> String.equals("AAAA"), StoLowerC);
//        s = m2(s, String -> String.equals("AAAA"), StoLower);
        s = m(s, String -> String.equals("AAAA"),String->String=String.toLowerCase());
        System.out.println(s);
        byte b[] = new byte[2];
        b[0] = 0x00;
        b[1] = (byte) 0xcc;
        int i = 0xcc;

                System.out.println("args = [" + Byte.toUnsignedInt( b[1]) + "]");
    }



}
