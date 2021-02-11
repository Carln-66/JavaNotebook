package CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @Auther: Carl
 * @Date: 2021/02/09/20:41
 * @Description:
 *  一、集合框架概述
 *  1. 集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *      此时的存储，主要指内存层面的存储，不涉及持久化的存储(.txt, .jpg, .avi, 数据库中)
 *  2. 数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，长度确定了
 *      > 数组一旦定义好，其元素的类型就确定了。我们也就只能操作指定类型的数据了。
 *          比如：String[] arr; int[] arr1; Object[] arr2;
 *      数组在存储多个数据的缺点：
 *      > 一旦初始化以后，其长度不可修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作非常不方便。同时效率不高
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求不能够满足。
 *
 *  二、集合框架
 *      |----Collection接口：单列集合，用来储存一个一个的对象
 *          |----List接口：有序的、可重复的数据  ---- "动态数组"
 *              |----ArrayList、LinkedList、Vector
 *          |----Set接口：无序的、不可重复的数据  ---- 类似于数学意义的"集合"
 *              |----HashSet、LinedHashSet、TreeSet
 *      |----Map接口：双列集合，用来存储一对(key - value)一对的数据    ---- 类比于函数 y=f(x)  (key->x, value->value)
 *          |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *
 *  三、Collection接口中的方法的使用
 *
 *
 *
 */
public class CollectionTest1 {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        Collection collection1 = new ArrayList();

        //add(Object e): 将元素e添加到集合Collection中
        collection.add("aa");
        collection.add("nm");
        collection.add(123);
        collection.add(new Date());

        //size(): 获取集合中添加的元素的个数
        System.out.println("*********size()*************");
        System.out.println(collection.size());
        System.out.println();

        //addAll(Collection collection1): 将collection1集合中的元素添加到当前的集合中
        System.out.println("*********addAll(Collection collection1)*************");
        collection1.add("test");
        collection1.add(0.3445);
        collection.addAll(collection1);

        System.out.println(collection.size());
        System.out.println(collection);

        System.out.println();

        //clear(): 清空集合元素
        System.out.println("*********clear()*************");
        collection1.clear();
        System.out.println(collection1.size());

        System.out.println();

        //isEmpty(): 判断当前集合是否有元素
        System.out.println("*********isEmpty()*************");
        System.out.println(collection.isEmpty());

        System.out.println();

        //




    }
}
