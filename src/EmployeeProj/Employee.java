package EmployeeProj;

import java.time.LocalDate;

/********
 * 构造器与类同名
 * 每个类可以有一个以上的构造器
 * 构造器可以有0个，1个或多个参数
 * 构造器没有返回数值
 * 构造器总是伴随着new操作符一起调用
 *
 */


class Employee {
    //private确保只有Employee类自身的方法能够访问这些实例字段，而其它类的方法不能够读写这些字段
    //这样是为了更好的封装
    private String name;        //实例字段通常属于某个类型
    private double salary;
    private LocalDate hireDays;



    public Employee(String n, double s, int year, int month, int day)   //类构造器(constructor)
    {
        name = n;           //String name = n   //报错，不能再构造器中定义与实例字段同名的局部变量
        salary = s;
        hireDays = LocalDate.of(year, month, day);
    }

    //以下是四个方法
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDays() {
        return hireDays;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}