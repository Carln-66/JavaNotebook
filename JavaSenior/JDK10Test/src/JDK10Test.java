import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Auther: Carl
 * @Date: 2021/02/27/13:56
 * @Description:
 */
public class JDK10Test {
    /*
        局部变量的类型推断
     */
    @Test
    public void test1() {
        //1. 声明变量时，根据所赋的值，推断变量的类型
        var num = 10;

        var list = new ArrayList<Integer>();
        list.add(10);

        //2. 遍历操作
        for (var i : list) {
            System.out.println(i);
        }

        //3. 普通的遍历操作
        for (var i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        //1. 局部变量不赋值便不能进行类型推断
//        var num;

        //2. Lambda表达式中，左面的函数式接口不能声明为var
//        var sup = () -> Math.random();
        Supplier<Double> sup1 = () -> Math.random();

        //3. 方法引用中：同Lambda表达式
//        var con = System.out::println;
        Consumer<String> con1 = System.out::println;

        //4. 数组的静态初始化中
        var arr = new int[]{1, 2, 3, 4, 5};
    }

    @Test
    public void test3() {
        //情况1：没有初始化的局部变量声明
        //情况2：方法的返回类型
        //情况3：方法的参数类型
        //情况4：构造器的参数类型
        //情况5：属性
        //情况6：catch块
    }

    //java10的新特性二：集合中新增的copyOf()，用于创建一个只读的集合
    @Test
    public void test4() {
        //示例1：
        var list1 = List.of("Java", "Python", "C");
        var copy1 = List.copyOf(list1);
        System.out.println(list1 == copy1); // true
        //示例2：
        var list2 = new ArrayList<String>();
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2); // false
        //示例1和2代码基本一致，为什么一个为true,一个为false?
        //结论：copyOf(Xxx, coll)：如果参数coll本身就是一个只读集合，则copyOf()返回值即为当前的coll
        //若coll参数不是一个只读集合，则copyOf()返回一个新集合，这个集合是只读的
    }
}
