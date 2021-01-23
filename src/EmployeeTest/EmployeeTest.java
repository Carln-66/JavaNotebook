package EmployeeTest;

import java.time.*;
/*********************************
 用户自定义类

 Employee类

 基础类定义形式
 class ClassName
 {
 field1
 field2
 . . .
 constructor1
 constructor2
 . . .
 method1
 method2
 . . .
 }

 *
 */
//程序功能：编写工资管理系统
public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        //构造数组，填入员工信息
        staff[0] = new Employee("张三", 75000, 1987, 5, 16);
        staff[1] = new Employee("李四", 52000, 1982, 10, 8);
        staff[2] = new Employee("王五", 40000, 1990, 12, 22);


        for (Employee e : staff)
            e.raiseSalary(5);

        for (Employee e : staff)
            System.out.println("name = " + e.getName() + ", Salary = " + e.getSalary() + ", hireDay = " +
                    e.getHireDays());
    }
}
