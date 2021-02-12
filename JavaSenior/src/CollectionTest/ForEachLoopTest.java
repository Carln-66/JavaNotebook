package CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Auther: Carl
 * @Date: 2021/02/10/18:40
 * @Description:
 *  JDK5.0 新增了foreach循环，用于遍历集合、数组
 *
 */
public class ForEachLoopTest {
    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add("lmx");
        collection.add(689);
        collection.add(new String("aaa"));

        //for(集合元素的类型 局部变量 : 集合/数组对象)
        //内部仍然调用迭代器
        for (Object obj : collection){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        for(int i : array){
            System.out.println(i);
        }
    }

    //练习
    @Test
    public void test3(){
        //方式一：普通for赋值
        String[] array = new String[]{"MM", "MM", "MM"};
        for (int i = 0; i < array.length; i++) {
            array[i] = "GG";
        }

        //方式二：增强for循环
        for(String s : array){
            s = "GG";
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
