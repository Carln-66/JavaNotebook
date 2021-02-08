package java_general_class.string_doc;

import org.junit.Test;

/**
 * @Auther: Carl
 * @Date: 2021/02/07/10:38
 * @Description: 字符串
 *              String字符串：使用一对" "表示
 *              1. String声明为final的，表示不可被继承。
 *              2. String实现了java.io.Serializable接口：表示字符串是支持序列化的。
 *                          Comparable<String>接口：表示String可以比较大小。
 *              3. String内部定义了final char[] value用于储存字符串数据
 *              4. String：代表不可变的字符序列：简称不可变性。
 *                  体现：1. 当对字符串重新赋值时，需要重写指定内存区域，不能使用原有的value进行赋值
 *                       2. 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value赋值
 *                       3. 当调用String的replace()方法时修改指定的字符或字符串时，也需要重新指定内存区域，不能使用原有的value赋值
 *              5. 通过字面量的方式(区别于new)给一个字符串赋值，此时的字符串值声明在字符串常量池中
 *              6. 字符串常量池中是不会存储相同内容的字符串的
 *
 *              String的实例化方式
 *              方式一：通过字面量定义的方式
 *              方式二：通过new+构造器的方式
 */
public class StringTest {
    @Test
    public void test1(){

        String s1 = "aaa";
        String s2 = "111";

        String s3 = "aaa111";
        String s4 = "aaa" + "111";
        String s5 = s1 + "111";
        String s6 = "aaa" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);   //true
        System.out.println(s3 == s5);   //false
        System.out.println(s3 == s6);   //fasle
        System.out.println(s5 == s6);   //false
        System.out.println(s3 == s7);   //false
        System.out.println(s5 == s6);   //false
        System.out.println(s5 == s7);   //false
        System.out.println(s6 == s7);   //false

        String s8 = s5.intern();        //返回值得到的s8使用的常量池中已经存在的"aaa111"
        System.out.println(s3 == s8);   //true

        //总结：常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量
        //只要有一个是变量，结果就在堆中
        //如果拼接的结果调用intern()方法，返回值就在常量池中

    }
}
