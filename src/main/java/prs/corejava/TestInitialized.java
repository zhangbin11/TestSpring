package prs.corejava;

/**
 * Created by zhangbin on 2017/6/27.
 */
public class TestInitialized {

    public static void main(String[] args) {
        int i=0;
        System.out.println(i);
        A a = new A();
        System.out.println(a.i);
    }

}


class A{
        public int i;
}
