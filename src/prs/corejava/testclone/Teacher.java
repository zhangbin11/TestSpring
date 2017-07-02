package prs.corejava.testclone;

import java.io.Serializable;

/**
 * Created by zhangbin on 2017/6/30.
 */
public class Teacher implements Cloneable,Serializable{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
