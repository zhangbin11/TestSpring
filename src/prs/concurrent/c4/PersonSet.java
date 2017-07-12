package prs.concurrent.c4;

import prs.concurrent.c3.Person;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangbin on 2017/7/12.
 *
 * 通过实力封闭 来保证线程的安全
 * 将hashset封装到自己的类中 保证多线程操作的安全
 */
public class PersonSet {


    private final Set<Person> personSet = new HashSet<>();

    public synchronized void addPerson(Person person){
        personSet.add(person);
    }

    public synchronized Boolean containsPerson(Person person){
        return personSet.contains(person);
    }

}
