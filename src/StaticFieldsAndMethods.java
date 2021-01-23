/****************
 静态字段和静态方法

 1. 静态字段
 如果将一个字段定义为static，每一个类只有一个这样的字段。而对于非静态的实例字段，每个对象都有一个自己的副本。
 例如，假设需要给每一个员工赋予唯一的标识码。这里给Employee类添加一个实例字段id和一个静态字段nextId
    class Employee
    {
        private static int nextId = 1;

        private int id
        . . .
    }
 现在，每一个Employee对象都有一个自己的id字段，但这个类的所有实例将共享一个nextId字段。换句话说，如果有1000个Employee类对象，
 则有1000个实例字段id，分别对应每一个对象。但是，只有一个静态字段nextId。即使没有Employee对象，静态字段nextId也存在。它属于
 类，而不属于任何单个对象。

 下面实现一个简单的方法
    public void setId()
    {
        id = nextId;
        nextId++;
    }
 假定为harry设置员工标识码
    harry.setId();
 harry的id字段被设置为静态字段nextId的当前的值，并且静态字段的nextId的值加1：
    harry.id = Employee.nextId;
    Employee.nextId++;

 2. 静态常量
 静态常量使用的比较少，但静态常量却很常用。例如
    public calss Math
    {
        . . .
        public static final double PI = 3.14159265358979323846;
        . . .
    }
 在程序中，可以用Math.PI来访问这个常量。

 如果省略关键字static，PI就变为了Math类的一个实例字段。也就是说需要通过Math类的一个对象来访问PI，并且每一个Math对象
 都有它自己的一个PI副本。

 3. 静态方法
 静态方法是不在对象上执行的方法。例如Math类的pow方法就是一个静态方法表达式
    Math.pow(x, a)
 上述表达式会计算幂x的a次幂。在完成于是暖湿，她并不使用任何Math对象。换句话说，他没有隐式参数。
 可以认为静态方法是没有this参数的方法。
 Employee类的静态方法不能访问id实例字段，因为它不能在对象上执行操作。但是静态方法可以访问静态字段。下面是示例
    public static int getNextId()
    {
        return nextId;      //返回静态字段
    }
 可以提供类名来调用这个方法：
    int n = Employee.getNextId();
 上述方法可以省略关键字static，但是这样一来就需要通过Employee类的对象的引用来调用这个方法。

 以下两种情况下可以使用静态方法
 * 方法不需要访问对象状态，因为它需要的所有参数都通过显式参数提供（例如：Math.pow）
 * 方法只需要访问类的静态字段（例如：Employee.getNextId）。
 *
 */

public class StaticFieldsAndMethods {
    public static void main(String[] args) {

    }
}
