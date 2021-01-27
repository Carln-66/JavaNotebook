package OOP;

/************
 *      类中方法的声明和使用
 *
 *      方法：描述类应该具有的功能
 *      比如，Math类：sqrt\random\...
 *          Scanner类：nextXxx() ...
 *          Arrays类：sort() \ binarySearch() \ toString \ equals() \ ...
 *      1. 举例
 *          public void eat(){}
 *          public void sleep(int hour){}
 *          public String getName(){
 *          public String getNation(String nation){}
 *
 *      2. 方法的声明：权限修饰符 返回值类型 方法名（形参列表）{
 *                      方法体;
 *                  }
 *      注意：static、final、abstract来修饰的方法在后面介绍
 *
 *      3. 说明：
 *          3.1 关于权限修饰符：
 *                  Java规定的4种权限修饰符：private、public、protected、缺省     --> 封装性
 *          3.2 返回值类型：有返回值  vs  没有返回值
 *              3.2.1 如果方法有返回值，则必须在方法声明时指定返回值的类型。同时，方法中需要使用return关键字来返回指定类型的变量或常量。
 *                    如果方法没有返回值：则方法声明时，使用void表示。
 *              3.2.2 我们定义方法的时候该不该有返回值？
 *                    ① 题目要求
 *                    ② 经验
 *          3.3 方法名：属于标识符，遵循标识符的规则规范
 *          3.4 形参列表： 方法可以声明0个，1个，或多个形参
 *              格式：数据类型1 形参1, 数据类型2 形参2, ...
 *              3.4.2 考虑我们定义方法时，该不该定义形参？
 *          3.5 方法体：方法功能的体现
 *
 *
 *
 */

public class CustomerTest {
}

//客户类
class Customer{
    //属性
    String name;
    int age;
    boolean isMale;

    //方法
    public void eat(){
        System.out.println("客户吃饭");
    }

    public void sleep(int hour){
        System.out.println("休息了" + hour + "个小时");
    }

    public String getName(){
        return name;
    }

    public String getNation(String nation){
        String info = "我的国籍是" + nation;
        return info;
    }


}

