package MethodReferences;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * 	1. 使用情景：当要传递给Lambda体的操作已经有实现的方法了，就可以使用方法引用
 * 	2. 方法引用：本质上还是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以方法引用，也是函数式接口的实例。
 * 	3. 使用格式：	类(或对象) :: 方法名
 * 	4. 具体分为如下的三种情况：
 * 		对象 :: 非静态方法
 * 		类 :: 静态方法
 * 		类 :: 非静态方法
 * 	5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表的形参列表和返回值类型相同(针对于对象 :: 非静态方法和类 :: 静态方法)
 *
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		Consumer<String> consumer = str -> System.out.println(str);
		consumer.accept("北京");

		System.out.println("+++++++++++++++++++++++++++++++++++++");

		PrintStream ps = System.out;
		Consumer<String> consumer1 = ps :: println;
		consumer1.accept("杭州");
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee employee = new Employee(1001, "张三", 25, 18000);
		Supplier<String> supplier1 = () -> employee.getName();
		System.out.println(supplier1.get());

		System.out.println("+++++++++++++++++++++++++++++++++++++");

		Supplier<String> supplier2 = employee :: getName;
		System.out.println(supplier2.get());

	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer>	comparator1 = (t1, t2) -> Integer.compare(t1, t2);
		System.out.println(comparator1.compare(56, 67));

		System.out.println("+++++++++++++++++++++++++++++++++++++");

		Comparator<Integer>	comparator2 = Integer :: compare;
		System.out.println(comparator2.compare(12, 6));
	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double, Long> func1 = d -> Math.round(d);
		System.out.println(func1.apply(12.3));

		System.out.println("+++++++++++++++++++++++++++++++++++++");

		Function<Double, Long> func2 = Math :: round;
		System.out.println(func1.apply(17.7));
	}

	// 情况三：类 :: 实例方法 (有难度)
	// Comparator中的int compare(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> comparator1 = (s1, s2) -> s1.compareTo(s2);
		System.out.println(comparator1.compare("aaa", "aad"));

		System.out.println("+++++++++++++++++++++++++++++++++++++");

		Comparator<String> comparator2 = String :: compareTo;
		System.out.println(comparator2.compare("jsakd", "cxgbuyz"));
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String, String> pre1 = (s1, s2) -> s1.equals(s2);
		System.out.println(pre1.test("cyu", "cuu"));

		System.out.println("+++++++++++++++++++++++++++++++++++++");

		BiPredicate<String, String> pre2 = String :: equals;
		System.out.println(pre2.test("cyu", "cyu"));

	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Employee employee = new Employee(100, "张三", 16, 8000);

		Function<Employee, String> func1 = e -> e.getName();
		System.out.println(func1.apply(employee));

		System.out.println("+++++++++++++++++++++++++++++++++++++");

		Function<Employee, String> func2 = Employee :: getName;
		System.out.println(func2.apply(employee));
	}
}
