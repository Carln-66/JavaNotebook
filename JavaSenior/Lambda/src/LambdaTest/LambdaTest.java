package LambdaTest;

import org.junit.Test;

import java.util.Comparator;

/**
 * @Auther: Carl
 * @Date: 2021/02/23/14:47
 * @Description:    Lambda表达式的使用举例
 *
 *
 */
public class LambdaTest {

    @Test
    public void test1(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个测试");
            }
        };

        runnable.run();

        System.out.println("------------------------------------");

        Runnable runnable1 = () -> System.out.println("这还是一个测试");

        runnable1.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(10, 11);
        System.out.println(compare1);

        System.out.println("-----------------------------------------");

        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);

        int compare2 = com2.compare(12, 11);
        System.out.println(compare2);

        System.out.println("-----------------------------------------");

        //方法引用
        Comparator<Integer> com3 = Integer::compare;

        int compare3 = com3.compare(12, 11);
        System.out.println(compare3);
    }

}
