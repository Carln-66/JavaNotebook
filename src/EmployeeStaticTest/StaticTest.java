package EmployeeStaticTest;

public class StaticTest {
    public static void main(String[] args) {
        var staff = new EmployeeStaticTest[3];  //var关键字由变量的初始值自动推导其类型，不用声明类

        staff[0] = new EmployeeStaticTest("Tom", 40000);
        staff[1] = new EmployeeStaticTest("Dick", 60000);
        staff[2] = new  EmployeeStaticTest("Harry", 65000);

        for (EmployeeStaticTest employee : staff)
        {
            employee.setId();
            System.out.println("name = " + employee.getName() + ", id = " + employee.getId()
                    + ", salary = " + employee.getSalary());
        }
    int n = EmployeeStaticTest.getNextId();
        System.out.println("Next available id = " + n);


    }
}
