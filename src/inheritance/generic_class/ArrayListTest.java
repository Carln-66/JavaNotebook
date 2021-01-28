package inheritance.generic_class;

import inheritance.object_class.Employee;

import java.util.ArrayList;

/**以下程序是对EmployeeTest作出修改后的程序。在这里，将Employee[ ]数组替换成了ArrayList<Employee>。请注意以下变化
 * 不必指定数组的大小
 * 使用add将任意多的元素添加到数组中
 * 使用size()而不是length统计元素个数
 * 使用a.get(i)而不是a[i]来访问元素
 */

public class ArrayListTest {
    public static void main(String[] args) {

        var staff = new ArrayList<Employee>();

        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

        for (Employee e : staff)
            e.raiseSalary(5);

        for (Employee e : staff)
            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary() + ", hireDay = " +
                    e.getHireDay());
    }
}
