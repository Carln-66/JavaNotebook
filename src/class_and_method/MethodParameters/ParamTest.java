package class_and_method.MethodParameters;

/******************************************
    程序语言中如何将参数传递给方法(或函数)的一些专业术语
 *  按值调用(call by value)表示方法接受的是调用者提供的值
 *  按引用调用(call by reference)表示方法接受的是调用者提供的变量地址。方法可以修改按引用传递的变量的值，而不能修改按值传递的变量的值

    ”按...调用“(call by)是一个标准的计算机科学术语，用来描述各种程序语言中方法参数的传递方式

    Java程序设计语言总是采用按值调用。也就是说，方法得到的是所有参数值的一个副本。具体来讲，方法不能修改传递给它的任何参数变量的内容

 例如，考虑下面的调用
        double percent = 10;
        harry.raiseSalary(percent)；
 不论这个方法具体如何实现，在方法调用之后，percent的值还是10.
 以下在研究这种情况。假定一个方法试图将一个参数值增加至3倍；
        public static void tripleValue(double x)   //不起作用
        {
            x = 3 * x;
        }
 然后调用这个方法
        double percent = 10;
        tripleValue(percent);
    这样并不能起作用。调用这个方法之后，percent的值还是10。
 下面是程序的执行过程
 *  x初始化为percent值的一个副本（也就是10）
 *  x乘以3后等于30，但是percent仍然是10
 *  这个方法结束之后，参数变量x不再使用

 有两种类型的方法参数：
 *  基本数据类型(数字, 布尔值)
 *  对象引用

 一个方法不可能修改基本数据类型的参数，而对象引用作为参数就不同了，可以很容易的利用如下方法将一个员工的工资增值三倍
        public static void tripleSalary(Employee x)     //起作用
        {
            x.raiseSalary(200);
        }
 当调用
        harry = new Employee(. . .);
        tripleSalary(harry)；
 时，具体的执行过程为
 *  x初始化为harry的一个副本，这里就是一个对象引用
 *  raiseSalary方法应用于这个对象引用。x和harry同时引用的那个Employee对象的工资提高了200%
 *  方法结束后，参数变量x不再使用。当然，对象变量harry继续引用那个工资增至3倍的员工对象

    可以看到，实现一个改变对象参数状态的方法是完全可以的，实际上也相当常见。理由很简单，方法得到的是对象引用的副本，原来的对象引用和这个副本都引用
 同一个对象。

    很多程序设计语言(尤其是C++和Pascal)提供了两种参数传递的方式：按值调用和按引用调用。实际上这种理解不对。以下反例可以说明这个问题。
 首先，编写一个交换两个Employee对象的方法
        public static void swap(Employee x, Employee y)     //不起作用
        {
            Employee temp = x;
            x = y;
            y = temp;
        }
    如果Java对对象采用的是按引用调用，那么这个方法就应该能够实现交换:
        var a = new Employee("Alice", . . .);
        var b = new Employee("Bob", . . .):
        swap(a, b);
 这两个方法并没有改变储存在变量a和b中的对象引用。swap方法的参数x和y被初始化为两个对象引用的副本，所以这个方法交换的是这两个副本
        //x表示Alice，y表示Bob
        Employee temp = x;
        x = y;
        y = temp;
        //现在a表示Bob，y表示Alice
    但是在最后，白费力气。在方法结束时参数变量x和y被丢弃了。原来的变量a和b依旧引用方法调用之前所引用的对象
    整个过程说明：Java程序设计语言对对象采用的不是按引用调用，实际上，对象引用是按值传递的。

    下面总结在Java中对方法参数能做什么和不能做什么
 *  方法不能修改基本数据类型的参数(即数值型或布尔型)
 *  方法可以改变对象参数的状态
 *  方法不能让一个对象参数引用一个新的对象
 */

//程序功能：测试变量
public class ParamTest {
    public static void main(String[] args) {
        //测试1：Method can't modify numeric parameters
        System.out.println("测试三倍数值为：");
        double percent = 10;
        System.out.println("更改前，百分比为：" + percent);
        tripleValue(percent);
        System.out.println("更改后，百分比为：" + percent);

        //测试2：Methods can cahnge the state of object parameters
        System.out.println("测试三倍工资");
        var harry = new Employee("Harry", 50000);
        System.out.println("更改前，工资为：" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("更改后，工资为：" + harry.getSalary());

        //测试3：Methods can't attach new objects to object parameters
        System.out.println("测试交换：");
        var a = new Employee("Alice", 70000);
        var b = new Employee("Bob", 60000);
        System.out.println("更改前：a = " + a.getName());
        System.out.println("更改前：b = " + b.getName());
        swap(a, b);
        System.out.println("更改后：a = " + a.getName());
        System.out.println("更改后：b = " + b.getName());
    }


    public static void tripleValue(double x)   //不起作用
    {
        x = 3 * x;
        System.out.println("结束方法 ，x = " + x);
    }

    public static void tripleSalary(Employee x)      //起作用
    {
        x.raiseSalary(200);
        System.out.println("结束方法 ，x = " + x.getSalary());
    }

    public static void swap(Employee x, Employee y)
    {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("结束方法：x = " + x.getName());
        System.out.println("结束方法：y = " + y.getName());
    }
}
