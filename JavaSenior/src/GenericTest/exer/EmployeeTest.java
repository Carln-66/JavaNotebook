package GenericTest.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Auther: Carl
 * @Date: 2021/02/12/15:36
 * @Description:
 */
public class EmployeeTest {

    //按照生日日期的先后排序
    @Test
    public void test2() {

        TreeSet<Employee> treeSet = new TreeSet<>(new Comparator<Employee>() {

            //指明泛型时的写法
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate birthday1 = o1.getBirthday();
                MyDate birthday2 = o2.getBirthday();

                return birthday1.compareTo(birthday2);
            }


            //未指定泛型时的写法
//            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof Employee && o2 instanceof Employee) {
//                    Employee employee1 = (Employee) o1;
//                    Employee employee2 = (Employee) o2;
//
//                    MyDate birthday1 = employee1.getBirthday();
//                    MyDate birthday2 = employee2.getBirthday();
//
//                    return birthday1.compareTo(birthday2);
//                }
//                throw new RuntimeException("传入数据类型不一致");
//            }
        });

        Employee employee1 = new Employee("zhangsan", 16, new MyDate(1999, 12, 15));
        Employee employee2 = new Employee("lisi", 20, new MyDate(1989, 4, 26));
        Employee employee3 = new Employee("wangwu", 5, new MyDate(1989, 4, 27));
        Employee employee4 = new Employee("zhaoliu", 52, new MyDate(2002, 7, 12));
        Employee employee5 = new Employee("zhouqi", 34, new MyDate(1995, 6, 4));

        treeSet.add(employee1);
        treeSet.add(employee2);
        treeSet.add(employee3);
        treeSet.add(employee4);
        treeSet.add(employee5);

        Iterator<Employee> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    //使用自然排序
    @Test
    public void test1() {
        TreeSet<Employee> treeSet = new TreeSet<>();

        Employee employee1 = new Employee("zhangsan", 16, new MyDate(1999, 12, 15));
        Employee employee2 = new Employee("lisi", 20, new MyDate(1989, 4, 26));
        Employee employee3 = new Employee("wangwu", 5, new MyDate(1989, 2, 27));
        Employee employee4 = new Employee("zhaoliu", 52, new MyDate(2002, 7, 12));
        Employee employee5 = new Employee("zhouqi", 34, new MyDate(1995, 6, 4));

        treeSet.add(employee1);
        treeSet.add(employee2);
        treeSet.add(employee3);
        treeSet.add(employee4);
        treeSet.add(employee5);

        Iterator<Employee> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee);
        }
    }
}
