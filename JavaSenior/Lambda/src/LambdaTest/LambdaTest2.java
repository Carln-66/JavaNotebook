package LambdaTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Auther: Carl
 * @Date: 2021/02/23/16:22
 * @Description:
 *  Java内置的四大核心函数式接口
 *  消费型接口   Consumer<T>     void accept(T t)
 *  供给型接口   Supplier<T>     T get()
 *  函数型接口   Function<T, R>  R apply(T t)
 *  断定行接口   Predicate<T>    boolean test(T t)
 */
public class LambdaTest2 {
    @Test
    public void test1(){
        happyTime(100, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("普通方法" + aDouble);
            }
        });
        System.out.println("=====================================");
        happyTime(200, money -> System.out.println("Lambda表达式" + money));
    }

    public void happyTime(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京", "南京", "上海", "广州", "温州");
        List<String> filterString = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("州");
            }
        });
        System.out.println(filterString);

        System.out.println("===================================================");

        List<String> filterStrings = filterString(list, s -> s.contains("京"));
        System.out.println(filterStrings);
    }

    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String>list, Predicate<String> predicate){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
