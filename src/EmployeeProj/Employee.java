package EmployeeProj;

import java.time.LocalDate;

/********
 * 构造器与类同名
 * 每个类可以有一个以上的构造器
 * 构造器可以有0个，1个或多个参数
 * 构造器没有返回数值
 * 构造器总是伴随着new操作符一起调用
 *
 想要获得或设置实例字段的值，需要提供以下三项的内容
 * 一个私有的数据字段
 * 一个公共的字段访问器方法
 * 一个公共的字段更改器方法
 */


class Employee {
    //private确保只有Employee类自身的方法能够访问这些实例字段，而其它类的方法不能够读写这些字段
    //这样是为了更好的封装
    //实例字段通常属于某个类型
    //可以将实例字段定义为final。这必须确保在每个构造器执行之后，这个字段的值已经设置，并且无法再修改。
    private String name;        //因为这个对象在构造后，值不会再改变，因为可以将此字段声明为
                                //      private final String name;
    //final修饰符对于基本类型或者不可变类(类中所有方法都不会改变其对象)字段尤其有用。
    //例如String类就是不可变的
    private double salary;
    private LocalDate hireDays;



    public Employee(String n, double s, int year, int month, int day)   //类构造器(constructor)
    {
        name = n;           //String name = n   //报错，不能再构造器中定义与实例字段同名的局部变量
        salary = s;
        hireDays = LocalDate.of(year, month, day);
    }

    //以下是四个典型的访问器方法，它们只返回实例字段值，因此又称为字段访问器。
        public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDays() {
        return hireDays;
    }

    //raiseSalary方法有两个参数。
    //第一个参数称为隐式(implicit)参数，是出现在方法名前的Employee类型的对象。
    //第二个参数是位于方法名后面括号中的数值，这是一个显式(explicit)参数。
    //显示参数显式的的列在方法声明中，例如double byPercent。隐式参数没有出现在方法声明中。
    //在每一个方法中，关键字this指示隐式参数。同样可以用以下方法改写
    //  public void raiseSalary(double byPercent)
    //  {
    //      double raise = this.salary * byPercent / 100;
    //      this.salary += raise;
    //  }
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}