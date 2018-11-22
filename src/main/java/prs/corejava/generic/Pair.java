package prs.corejava.generic;

/**
 * Created by zhangbin on 2017/7/3.
 */
public class Pair<T,U> {

    private T first;
    private U second;


    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public static void main(String[] args) {
        Pair<String,Integer> p = new Pair<>();
        p.setFirst("first");
        p.setSecond(2);

        System.out.println(p.getFirst());
        System.out.println(p.getSecond());
    }
}
