package oop;

/*
 *              一、构造器的作用
 *                  1. 创建对象
 *                  2. 初始化属性
 *                  3. 一个类中定义的多个构造器，彼此构成重载
 *                  4. 一旦我们显式的定义了类的构造器，系统就不再提供默认的空参数构造器
 *                  5. 一个类中，至少会有一个构造器
 *
 *              二、说明
 *                  1. 如果没有显式的定义类的构造器的话，则系统默认提供一个空参的构造器
 *                  2. 定义构造器的格式：权限修饰符 类名(形参列表){}
 *
 */

public class ConstructorTest {
    public static void main(String[] args) {

        constructor c = new constructor();
        constructor c1 = new constructor("Tom");
        System.out.println(c1.name);
    }
}

class constructor{
    //属性
    String name;
    int age;

    //构造器
    public constructor(){
        System.out.println("Constructor()......");
    }

    public constructor(String n){
        name = n;
    }

    //方法
    public void eat(){
        System.out.println("人吃饭");
    }

    public void study(){
        System.out.println("人学习");
    }
}