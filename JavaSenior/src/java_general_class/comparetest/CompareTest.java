package java_general_class.comparetest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: Carl
 * @Date: 2021/02/08/16:03
 * @Description: Java比较器
 * 一、说明：Java中的对象，正常情况下只能比较：== 或 !=  不能使用 > 或 <
 * 但是在开发场景中，我们需要对多个对象进行排序，言外之意，需要比较对象的大小。
 * 如何实现？使用两个接口中的任意一个：Compare或Comparator
 * 二、Comparable接口的使用
 *
 * 三、Comparable接口与Comparator的使用对比
 * Comparable接口的方式一旦确定，保证Comparable接口实现类的对象在任何位置都可以比较大小
 * Comparator接口属于临时性的比较
 */
public class CompareTest {

    @Test
    /*
    Comparable接口的使用举例：自然排序
    1. 像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式
    2. 像String、包装类重写ComparableTo()方法之后，进行了小到大的排列
    3. 重写CompareTo(obj)的规则:
        如果当前对象this大于形参对象obj，则返回正整数，
        如果当前对象this小于形参对象obj，则返回负整数，
        如果i当前对象this等于形参对象obj，则返回零。
    4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo()方法
        在compareTo(obj)方法中指明排序方式
     */
    public void test1() {
        String[] arr = new String[]{"BB", "FF", "AA", "CC", "SS", "EE", "ZZ", "DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        Goods[] arr1 = new Goods[4];
        arr1[0] = new Goods("Lenovo", 18000);
        arr1[1] = new Goods("Apple", 50000);
        arr1[2] = new Goods("Dell", 20000);
        arr1[3] = new Goods("HUAWEI", 17000);

        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

        /*
    Comparator接口的使用：定制排序
    1. 背景：当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，或者实现了java.lang.Comparable接口的
        排序规则不适合当前的操作，那么可以考虑使用 Comparator 的对象来排序，
    2. 重写compare(Object o1,Object o2)方法，比较o1和o2的大小：如果方法返回正整数，则表示o1大于o2；如果返回0，表示
        相等；返回负整数，表示o1小于o2。

     */

    @Test
    public void test3() {
        String[] arr = new String[]{"BB", "FF", "AA", "CC", "SS", "EE", "ZZ", "DD"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("输入数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4() {
        Goods[] arr1 = new Goods[4];
        arr1[0] = new Goods("Lenovo", 18000);
        arr1[1] = new Goods("Apple", 50000);
        arr1[2] = new Goods("Dell", 20000);
        arr1[3] = new Goods("HUAWEI", 17000);

        Arrays.sort(arr1, new Comparator() {
            //指明产品比较大小的方式：按照产品名称从低到高排序，再按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if (g1.getName().equals(g2.getName())) {
                                return Double.compare(g1.getPrice(), g2.getPrice());
                    } else {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("传入数据类型不一致" );
            }

        });
        System.out.println(Arrays.toString(arr1));
    }
}
