import MethodReferences.Employee;
import MethodReferences.EmployeeData;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: Carl
 * @Date: 2021/02/26/11:02
 * @Description:
 *  测试Stream的终止操作
 */
public class StreamAPITest2 {
    //匹配与查找
    @Test
    public void test1(){

        List<Employee> employees = EmployeeData.getEmployees();

        //allMatch(Predicate p) -- 检查是否匹配所有元素。
        // 练习：是否所有员工的年龄都大于18
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println("是否所有员工的年龄都大于18: " + b);

        //anyMatch(Predicate p) -- 检查是否至少匹配一个元素。
        // 练习：是否存在员工的工资大于10000
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println("是否存在员工的工资大于10000: " + b1);

        //noneMatch(Predicate p) -- 检查是否没有匹配的元素。练习：是否存在员工姓"雷"
        boolean b2 = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println("练习：是否存在员工姓雷: " + b2);

        //findFirst -- 返回第一个元素
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println("返回第一个元素: " + employee);

        //findAny -- 返回当前流中的任意元素

        //count -- 返回流中元素的总个数

        //max(Comparator c) -- 返回流中最大值

        //练习：返回最高的工资

        //min(Comparator c) -- 返回流中的最小值

        //练习，返回最低工资的员工

        //forEach(Consumer c) -- 内部迭代
    }
}
