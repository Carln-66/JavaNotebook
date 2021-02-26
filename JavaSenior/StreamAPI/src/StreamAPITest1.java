import MethodReferences.Employee;
import MethodReferences.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Auther: Carl
 * @Date: 2021/02/24/19:31
 * @Description:
 *  测试Stream的中间操作
 */
public class StreamAPITest1 {

    //筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
        //filter(Predicate p) -- 接收Lambda，从中排除某些元素
        Stream<Employee> stream = list.stream();
        //查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println();
        //limit(n) -- 截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);

        System.out.println();
        //skip(n) -- 跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流。与limit(n)互补
        list.stream().skip(100).forEach(System.out::println);

        System.out.println();
        //distinct() -- 筛选，通过流所声称元素的hashCode()和equals()去除重复元素
        list.add(new Employee(1010, "马化腾", 22, 6520.38));
        list.add(new Employee(1010, "马化腾", 22, 6520.38));
        list.add(new Employee(1010, "马化腾", 22, 6520.38));
        list.add(new Employee(1010, "马化腾", 22, 6520.38));
        list.add(new Employee(1010, "马化腾", 22, 6520.38));
        list.add(new Employee(1010, "马化腾", 22, 6520.38));
        list.add(new Employee(1010, "马化腾", 22, 6520.38));
        list.add(new Employee(1010, "马化腾", 22, 6520.38));

        list.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2(){
        //map(Function f) -- 接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        //练习1：获取员工姓名长度大于3的员工的姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stringStream = employees.stream().map(Employee::getName);
        stringStream.filter(name -> name.length() > 3).forEach(System.out::println);
        System.out.println();

        //练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println();

        //flatMap(Function f) -- 接收一个函数作为参数，将流中每个值都换成另一个流
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    //排序
    @Test
    public void test3() {
        //sorted() 自然排序
        List<Integer> list = Arrays.asList(156, 123, 4, 78, 12, -535);
        list.stream().sorted().forEach(System.out::println);

        //抛异常。原因：Employee类没有实现Comparator接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com)  定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1, e2) -> {
            int compare = Integer.compare(e1.getAge(), e2.getAge());
            if (compare != 0) {
                return compare;
            } else {
                return -Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).forEach(System.out::println);
    }
}
