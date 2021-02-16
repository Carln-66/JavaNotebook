package CollectionsTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/02/13/12:38
 * @Description:
 *  Collections: 操作Collection、Map的工具类
 *
 * reverse(List)：反转 List 中元素的顺序
 * shuffle(List)：对 List 集合元素进行随机排序
 * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
 * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
 *
 * 查找、替换
 * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
 * Object min(Collection)
 * Object min(Collection，Comparator)
 * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 * void copy(List dest,List src)：将src中的内容复制到dest中
 * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值
 *
 *
 *  问题：Collection和Collections的区别？
 *  Collection是接口
 *  Collections是操作Collection接口的工具类
 *
 *  Collections类中提供了多个 synchronizedXxx()方法，该方法可使将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题
 *
 *
 *
 */
public class CollectionsTest {

    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(465);
        list.add(-56);
        list.add(589);
        list.add(12);
        list.add(408);
        list.add(52);
        list.add(-5);

        //返回的list为线程安全的list
        List synchronizedList = Collections.synchronizedList(list);

    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(465);
        list.add(-56);
        list.add(589);
        list.add(12);
        list.add(408);
        list.add(52);
        list.add(-5);

        //抛异常：java.lang.IndexOutOfBoundsException: Source does not fit in dest
//        List dest = new ArrayList();
//        Collections.copy(dest, list);
//        System.out.println(dest);

        //正确
        List<Object> list1 = Arrays.asList(new Object[list.size()]);
        System.out.println(list1.size());
        Collections.copy(list1, list);
        System.out.println(list1);


    }

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(465);
        list.add(-56);
        list.add(589);
        list.add(12);
        list.add(408);
        list.add(52);
        list.add(-5);

        System.out.println(list);
        System.out.println();
        Collections.reverse(list);
        System.out.println(list);

        System.out.println();

        Collections.shuffle(list);
        System.out.println(list);

        System.out.println();

        Collections.sort(list);     //如果降序排列只需要在后面 Collections.reverse(list);
        System.out.println(list);

        System.out.println();

        Collections.swap(list, 1, 2);
        System.out.println(list);

        System.out.println();

        Comparable max = Collections.max(list);
        System.out.println(max);

    }
}
