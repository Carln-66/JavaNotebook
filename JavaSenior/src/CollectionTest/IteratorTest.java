package CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Auther: Carl
 * @Date: 2021/02/10/10:47
 * @Description:
 *
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1. 内部的方法hasNext()和next()
 * 2. 集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
 * 3. 内部定义了remove()，可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add("lmx");
        collection.add(689);
        collection.add(new String("aaa"));

        //方式一
        Iterator iterator = collection.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //抛出异常：NoSuchElementException
//        System.out.println(iterator.next());

        //方式二：不推荐
//        for (int i = 0; i < collection.size(); i++) {
//            System.out.println(iterator.next());
//
//        }

        //方式三：推荐
        //hasNext(): 判断该集合当前指针位置处是否还有下一个元素，若返回true则进入next()方法
        //next(): 指针下移，将下移后集合位置上的元素返回
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //测试Iterator中的remove()
    @Test
    public void test2(){
        Collection collection = new ArrayList();
        collection.add("lmx");
        collection.add(689);
        collection.add(new String("aaa"));

        //删除集合中"aaa"
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            if ("aaa".equals(next)){
                iterator.remove();
            }
        }
        //重新遍历集合
        iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
