import MethodReferences.Employee;
import MethodReferences.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        //练习：先按年龄从小到大排序，再按工资从少到多排序，最后返回第一个元素
        List<Employee> employees1 = EmployeeData.getEmployees();
        Optional<Employee> first = employees1.stream().sorted((e1, e2) -> {
            int compare = Integer.compare(e1.getAge(), e2.getAge());
            if (compare != 0) {
                return compare;
            } else {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).findFirst();
        System.out.println("先按年龄从小到大排序，再按工资从少到多排序，最后返回第一个元素" + first);

        //findAny -- 返回当前流中的任意元素
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
    }

    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();

        //count -- 返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println("返回流中工资大于5000元素的总个数: " + count);

        //max(Comparator c) -- 返回流中最大值
        //练习：返回最高的工资
        Stream<Double> salary = employees.stream().map(Employee::getSalary);
        Optional<Double> maxSalary = salary.max(Double::compare);
        System.out.println("返回最高的工资: " + maxSalary);

        //min(Comparator c) -- 返回流中的最小值
        //练习，返回最低工资的员工
        Optional<Employee> min = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("返回最低工资的员工: " + min);

        //forEach(Consumer c) -- 内部迭代
        employees.stream().forEach(System.out::println);

        //使用集合的遍历操作
        employees.forEach(System.out::println);
    }

    @Test
    //归约
    public void test3(){
        List<Employee> employees = EmployeeData.getEmployees();

        //reduce(T identity, BinaryOperator) -- 可以将流中元素反复结合起来，得到一个值。返回T
        //练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 4, 89, 11, -98, -32, 66);

        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println("计算集合(1, 2, 4, 89, 11, -98, -32, 66)之和: " + sum);

        //reduce(BinaryOperator) -- 可以将流中元素反复结合起来，得到一个值。返回Optional<T>
        //练习2：计算公司所有员工工资之和
        Optional<Double> sumSalary = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println("计算公司所有员工工资之和: " + sumSalary);
    }

    //收集
    @Test
    public void test4(){

        //collect(Collector c) -- 将流转换为其他形式。接受一个Collector接口的实现，用于给Stream中元素做汇总的方法
        //练习1：查找工资大于6000的员工，返回结果为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println();

        Set<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        collect1.forEach(System.out::println);
    }
}
