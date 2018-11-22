package prs.concurrent.c3;

/**
 * Created by zhangbin on 2017/7/10.
 */
public class TestFinal {

    private final Person person;

    public TestFinal() {
        this.person = new Person();
        person.setName("1");
    }

    public Person getPerson() {
        return person;
    }

    public static void main(String[] args) {
        TestFinal t = new TestFinal();
        Person p = t.getPerson();
        p.setName("2");
        p.setName("3");
        System.out.println(p.getName());
    }

}
