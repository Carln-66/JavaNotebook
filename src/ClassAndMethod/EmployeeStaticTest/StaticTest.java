package ClassAndMethod.EmployeeStaticTest;

public class StaticTest {
    public static void main(String[] args) {
        var staff = new Employee[3];  //var关键字由变量的初始值自动推导其类型，不用声明类

        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Dick", 60000);
        staff[2] = new Employee("Harry", 65000);

        for (Employee employee : staff)
        {
            employee.setId();
            System.out.println("name = " + employee.getName() + ", id = " + employee.getId()
                    + ", salary = " + employee.getSalary());
        }
    int n = Employee.getNextId();
        System.out.println("Next available id = " + n);


    }
}
