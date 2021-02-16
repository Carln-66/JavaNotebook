package object_stream;

import java.io.Serializable;

/**
 * @Auther: Carl
 * @Date: 2021/02/16/20:55
 * @Description:
 *
 *  Person类需要满足如下的要求方可序列化
 *  1. 需要实现一个标识接口：Serializable
 *  2. 需要当前类提供一个全局常量serialVersionUID
 *  3. 除了当前类需要实现Serializable接口之外，还必须保证其内部所有属性也必须是可序列化的(默认情况下，基本数据类型可序列化)。
 *
 *
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 4356746374642L;

    private String name;
    private int age;
    private Account account;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Account account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", account=" + account +
                '}';
    }
}

class Account implements Serializable{

    public static final long serialVersionUID = 44654886453412L;

    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}


