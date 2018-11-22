package prs.corejava.testclone;

import java.io.IOException;

/**
 * Created by zhangbin on 2017/6/30.
 */
public class TestClone {

    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.setName("t1");
        t1.setAge(11);
        Teacher t2 = new Teacher();
        t2.setName("t2");
        t2.setAge(22);

        Student s1 = new Student();
        s1.setAge(11);
        s1.setName("s1");
        s1.setTeacher(t1);
        try {
            Student s2 = (Student) s1.clone();
           // s2.setTeacher(t2);
            s2.getTeacher().setName("xxxxxxxxx");
            System.out.println(s1.getTeacher().getName());
            System.out.println(s2.getTeacher().getName());
            Student s3 = s1.deepClone();
            s3.getTeacher().setName("t33333333333");
            System.out.println("==========================");
            System.out.println(s1.getTeacher().getName());
            System.out.println(s2.getTeacher().getName());
            System.out.println(s3.getTeacher().getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
