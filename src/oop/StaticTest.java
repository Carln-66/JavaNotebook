package oop;

/**
 *      static关键字的使用
 *      1. static：静态的
 *      2. static可以用来修饰：属性、方法、代码块、内部类
 *      3. 使用static修饰属性：静态变量(类变量)
 *          3.1 属性按是否使用static修饰又分为：静态属性和非静态属性(实例变量)
 *          实例变量：我们创建了类的多个对象，每个对象都独立的拥有一套类中的非静态属性。修改其中一个对象的非静态属性时，不会影响其他对象中
 *                  同样的属性值。
 *          静态变量：我们创建了类的多个对象，多个对象共享同一个静态变量。但通过某一个对象修改静态变量时，会导致其他对象调用此静态变量时，
 *                  会修改其他对象的此项属性。
 *          3.2 static修饰属性的其他说明：
 *              1. 静态变量随着类的加载而加载，随着类的抹去而抹去。可以通过"类.静态变量"的方式进行调用
 *              2. 静态变量的加载要早于对象的创建
 *              3. 由于类只会加载一次，则静态变量在内存中也只会存在一份：存在方法区的静态域中。
 *              4.      类变量     实例变量
 *              类       yes         no
 *              对象      yes        yes
 *          3.3 静态属性举例：Sysytem.out； Math.PI
 *
 *      4. 使用static修饰方法：静态方法
 *          4.1 随着类的加载而加载，随着类的抹去而抹去。可以通过"类.静态方法"的方式调用
 *          4.2      静态方法     非静态方法
 *           类       yes         no
 *          对象      yes         yes
 *          4.3 静态方法中：只能调用静态的方法或者属性
 *              非静态方法中：既可以调用非静态的方法和属性，也可以调用静态的方法或属性
 *      5. static注意点
 *          5.1 在静态的方法内部不能使用this关键字和super关键字
 *          5.2 关于静态属性和静态方法的使用，都从类和对象的生命周期角度理解
 *      6. 开发中如何确定属性是否要声明为static
 *          > 属性可以被多个对象共享，不会随着对象之间的差异产生变化的，可以将属性声明为静态的。
 *          > 类中的常量也常常声明为static
 *         开发中如何确定方法是否要声明为static
 *          > 操作静态属性的方法通常设置为静态的
 *          > 工具类中的方法，习惯上声明为静态的。比如Math、Arrays、Collections
 *
 *
 */
public class StaticTest {
    public static void main(String[] args) {
        Chinese.nation = "中国";      //不报错
        Chinese c1 = new Chinese();
        c1.name = "张三";
        c1.age = 20;
        Chinese c2 = new Chinese();
        c2.name = "李四";
        c2.age = 30;

        c1.nation = "CHN";
        System.out.println(c2.nation);  //CHN
    }
}

class Chinese{
    String name;
    int age;
    static String nation;
}