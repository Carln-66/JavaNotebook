package CollectionTest.SetTest;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Auther: Carl
 * @Date: 2021/02/12/8:38
 * @Description:
 *
 *      |----Collection接口：单列集合，用来储存一个一个的对象
 *          |----Set接口：储存无序的、不可重复的数据  ---- 类似于数学意义的"集合"
 *              |----HashSet: 作为Set接口的主要实现类；线程不安全，可以储存null值
 *                  |----LinedHashSet: 作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
 *              |----TreeSet: 可以按照添加对象的指定属性进行排序。
 *
 * Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法。
 * 要求：向Set(主要指HashSet和LinkedHashSet)中添加的数据，其所在的类一定要重写hashCode()和equals()
 *      重写的hashCode和equals()尽可能保持一致性：相等的对象必须具有相等的散列码
 * 重写两个方法的技巧：对象中用作equals()方法比较的Field，都应该用来计算hashCode值。
 *
 */
public class SetTest {

    /*
    一、Set：储存无序的、不可重复的数据
    以HashSet为例：
    1. 无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的Hash值决定的。

    2. 不可重复性：保证添加的元素按照equals()判断时，不能返回ture，即相同的元素只能添加一个。

    二、添加元素的过程，以HashSet为例：
        我们向HashSet中添加元素a，首先调用a所在类的HashCode()方法，计算元素a的哈希值，此哈希值接着通过某种算法，计算出HashSet底层数组中的存放位置(即为：索引位置)，判断数组此位置上是否已经有元素：
        如果此位置上没有其他元素，则元素a添加成功 ---> 情况一
        如果此位置上有其他元素b(或以链表形式存在的多个元素)，则比较元素a与元素b的hash值：
            如果hash值不相同，则元素a添加成功 ---> 情况二
            如果hash值相同，进而需要调用元素a所在类的equals()方法：
                equals()返回true，元素a添加失败
                equals()返回false，则元素a添加成功 ---> 情况三

        对于添加成功的情况二和情况三而言：元素a与已经存在指定索引位置上数据以链表的形式存储
        JDK7：元素a放入数组中，指向原来的元素
        JDK8：原来的元素在数组中，指向元素a

        HashSet底层：数组+链表的结构

     */
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(123);
        set.add("abc");
        set.add("XXX");
        set.add("///");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet的使用
    //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据
    //优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add("abc");
        set.add("XXX");
        set.add("///");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
