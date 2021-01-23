package EmployeeProj;

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

        /**************************************************************
            Employee harry = new Employee("Harry Hacker", 5000,1989, 10, 1);
        可以利用var声明局部变量直接写成以下形式
            var harry = new Employee("Harry Hacker", 5000,1989, 10, 1);
        这样做可以避免重复写类名Employee

        对于一个null值应用方法，会产生一个NullPointerException异常
        LocalDate birthday = null;
        String s = birthday.toString();   //NullPointerException
        对此有两种解决办法。”宽容性“方法是吧null参数转换为一个适当的非null值
            if (n == null) name = "unknow"; else name = n;

         同时，Object类为此提供一个便利方法
            public Employee(String n, double s, int year, int month, int day)
            {
                name = Objects.requireNonNullElse(n, "Unknown");
                . . .
            }

         ”严格型“直接拒绝null参数：
                public Employee(String n, double s, int year, int month, int day)
            {
                Obiects.requireNonNull(n, "The name cannot be null");
                name = n;
                . . .
            }

         如果有人用一个null名字构造了一个Employee对象，就会产生NullPointerException异常
         * 异常会报告提供这个问题的描述
         * 一场会准确的指出问题所在的位置，否则NullPointerException异常可能在其他地方出现。而很难追踪到真正导致问题的这个构造器参数
         ****************************************************************/


        for (Employee e : staff)
            e.raiseSalary(5);

        for (Employee e : staff)
            System.out.println("name = " + e.getName() + ", Salary = " + e.getSalary() + ", hireDay = " +
                    e.getHireDays());
    }
}
