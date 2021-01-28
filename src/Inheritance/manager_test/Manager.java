package Inheritance.manager_test;

public class Manager extends Employee {     //利用extends调用超类Employee类

    private double bonus;

    /**
     * @param name the employee's name
     * @param salary the Salary
     * @param year the hire year
     * @param month the hire month
     * @param day the hire day
     */

    public Manager(String name, double salary, int year, int month, int day)
    {
        super(name, salary, year, month, day);      //调用超类Employee类中带有n, s, year, month和day参数的构造器
        bonus = 0;
    }

    public double getSalary()
    {
        double baseSalary = super.getSalary();      //super调用Employee类中的getSalary方法
        return baseSalary + bonus;
    }

    public void setBonus(double b)                  //setBonus方法将b赋给bonus，通过上述getSalary方法返回最终工资
    {
        bonus = b;
    }
}
