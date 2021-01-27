package ClassAndMethod;

import java.util.Date;

/**************************************************
    对象与类
面向对象的程序设计(object-oriented programming,OOP)
    1. 类

    2. 对象
    要想使用OOP，要清楚对象的三个主要特性
 *  对象的行为(behavior)——可以对对象完成哪些操作，或者对对象应用哪些方法
 *  对象的状态(state)——当调用哪些方法时，对象会如何响应
 *  对象的标识(identity)——如何区分具有相同行为而具有家族式的相似性。对象的行为是用可调用的方法来定义的

    3. 识别类
    传统的过程是程序中，必须从顶部的main函数开始编写程序。在面向对象程序设计时没有所谓的“顶部”。学习OOP应先从识别类开始，在为各个类添加方法。识别
 类的一个简单经验是在分析问题的过程中寻找名词，而方法对应着动词。

    4. 类之间的关系
    在类之间，最常见的关系有
 *  依赖("uses-a");
 *  聚合("has-a");
 *  继承("is-a");

    5. 对象与对象变量
    要想使用对象，首先必须构造对象，并指定其初始状态。然后对对象应用方法。
    在Java程序设计语言中，要使用构造器(constructor，或称为构造函数)构造新实例。构造器是一种特殊的方法，用来初始化对象。
 */

public class ObjectOrientedProgramming {
    public static void main(String[] args) {
        //要想构造一个Date对象，需要在构造器前面加上new操作符,new Date()这个表达式构造了一个新对象
        //这个对象被初始化为当前的日期和时间，如果需要的话，也可以将这个对象传递给以下方法
        System.out.println(new Date());

        //或者，也可以对刚刚创建的对象应用一个方法
        //Date类中有一个toString方法。这个方法将返回日期的字符串描述。
        String s = new Date().toString();

        //如果想多次使用对象，需要将对象存放在一个变量中
        Date birthday = new Date();
    }
}
