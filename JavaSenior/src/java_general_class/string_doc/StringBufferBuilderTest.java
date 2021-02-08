package java_general_class.string_doc;

import org.junit.Test;

/**
 * @Auther: Carl
 * @Date: 2021/02/07/12:48
 * @Description: StringBuffer和StringBuilder的使用
 *          String、StringBuffer、StringBuilder的区别
 *          String：不可变的字符序列；底层使用char[]存储；
 *          StringBuffer：可变的字符序列；线程安全，但效率低；底层使用char[]存储
 *          StringBuilder：可变的字符序列；JDK5.0新增。线程不安全，效率高；底层使用char[]存储
 *
 *          源码分析：
 *          String str = new String();  //new char[0];
 *          String str1 = new String("abc")     //new char[]{'a', 'b', 'c'};
 *
 *          StringBuffer sb1 = new StringBuffer();  //char[] value = new char[16]; 底层创建了一个长度是16的char型数组。
 *          sb1.append('a');    //value[0] = 'a';
 *          sb1.append('b');    //value[1] = 'b';
 *          StringBuffer sb2 = new StringBuffer("abc"); //char[] value = new char["abc".length + 16];
 *
 *          System.out.println(sb2.length());   //3
 *          扩容问题：如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组
 *                  默认情况下，扩容为原来的2倍+2，同时将原有数组中的元素复制到新的数组中。
 *
 *          指导意义：开发中建议使用StringBuffer(int capacity)或StringBuilder(int capacity)
 *
 *          方法总结：
 *          增；append(xxx)
 *          删：delete(int start,int end)
 *          改：setCharAt(int n, char ch) / replace(int start, int end, String str)
 *          查：CharAt(int n)
 *          插：insert(int offset, xxx)
 *          长度：length()
 *          遍历：for() + charAt() / toString
 *
 *          String、StringBuffer、StringBuilder效率排序
 *          从高到低：StringBuilder > StringBuffer > String
 *
 */
public class StringBufferBuilderTest {

    @Test
    public void test1(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);

        s1.delete(2, 4);        //删除：左闭右开
        System.out.println(s1);

        s1.insert(2, false);
        System.out.println(s1);
        System.out.println(s1.length());

        s1.reverse();
        System.out.println(s1);
    }
}
