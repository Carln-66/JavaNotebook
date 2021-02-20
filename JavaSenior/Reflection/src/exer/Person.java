package exer;

import java.io.IOException;

/**
 * @Auther: Carl
 * @Date: 2021/02/20/20:46
 * @Description:
 */

@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface{

    private String name;
    int age;
    public int id;

    public Person() {
    }

    @MyAnnotation(value = "abc")
    private Person(String name){
        this.name = name;
    }

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public String display(String interests, int year)throws IOException, NullPointerException {
        return interests + year;
    }

    @Override
    public void info() {
        System.out.println("人类");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
