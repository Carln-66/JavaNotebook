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
 * 内部的方法hasNext()和next()
 *
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
}
