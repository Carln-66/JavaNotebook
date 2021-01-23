package Array;

import java.util.Arrays;

/************************************
 数组
 1. 声明数组
 数组是一种数据结构，用来储存同一类型值的集合，通过一个整型下标(index，或称索引)可以访问数组中的每一个值。
 在声明数组变量时，需要指出数组类型（数据元素类型紧跟[]）和数组变量的名字。下面声明了整型数组a
    int[] a;    //这条语句之声明了变量a，并没有将a初始化为一个真正的数组。应该使用new操作符创建数组。
    int[] a = new int[100];     //也可以写成     var a = new int[100];
 这条语句声明并初始化了一个可以储存100个整数的数组。
 * 数组长度不要求是常量：new int[n]会创建一个长度为n的数组
 * 一旦创建了数组，就不能再改变它的长度（了以改变单个的数组元素）
 * 如果程序运行中需要经常拓展数组的大小，就应该是用另一种数据结构——数据列表（array list）

 2. 访问数组元素
 前面的数组元素的下标从0-99(而非1-100).一旦创建了数组就可以在数组中填入元素。例如使用一个循环。
    int[] a = new int[100];
    for {int i = 0; i < 100; i++}
    a[i] = i;   //a数组的元素由0-99覆盖
    创建一个数字数组时，所有元素都初始化为0.boolean数组的元素会初始化为false。对象数组的元素则初始化为一个特殊值null，表示这些元素
    还未存放任何对象。
 想要获得数组中的元素个数，可以使用array.length

 3. for each循环
 Java拥有一种功能很强的循环结构，可以用来依次处理数组(或其它元素集合)中的每个元素，而不必考虑指定下标指/
 这种增强的for循环语句格式为：
    for (variable : collection) statement
 它定义一个变量用于暂存集合中的每一个元素，并执行相应的语句(当然，也可以是语句块)。
 collection这一集合表达式必须是一个数组或者是一个实现了Iterable接口的类对象(例如ArrayList)。
 例如：
    for (int element : a)
        System.out.println(element);    //打印数组a中的每一个元素，一个元素占一行。

 有一个更简单的方式可以打印数组中的所有值，即利用Arrays类的toString方法。调用Arrays.toString(a)，返回一个包含数组元素的字符串，
 这些元素包围在中括号内，并用逗号分隔，例如，"[2, 3, 5, 7, 11, 13]"。要想打印数组，只需要调用
    System.out.println(Arrays.toString(a));

 4. 数组拷贝
 在java中允许将一个数组变量拷贝到零一个数组变量。这时，两个变量将引用同一个数组。
 如果希望将一个数组的所有值拷贝到一个新的数组中去，则要使用Arrays类的copyOf方法；


 *
 *
 */



public class Array {
    public static void main(String[] args) {
        /*   创建数组对象并同时提供初始值的简写方式
            *这个语法中不需要使用new，甚至不用指定长度
        */
        int[] smallPrimes = {2, 3, 4, 6, 7,};

        //声明匿名数组
        int[] annoymous = {17, 18, 19, 37, 41 };
        smallPrimes = annoymous;

        //获得数组中的元素
        for (int i = 0; i < smallPrimes.length; i++)
            System.out.println(smallPrimes[i]);

        //通过数组拷贝将一个变量拷贝到另一个数组中
        int[] luckyNumbers = smallPrimes;
        luckyNumbers[4] = 12;

        //将一个数组的所有值拷贝到另一个数组中去，第二个参数是新数组的长度，这个方法通常用来增加数组的大小
        int[] copiedLuckyNumbers = Arrays.copyOf(luckyNumbers, luckyNumbers.length);

        //增加数组大小， 如果数组元素是数值型，那么额外的元素将被赋值为0；如果数组元素是布尔型，则被赋值为false。
        // 相反，如果长度小于原始数组的长度，则只拷贝前面的值
        luckyNumbers = Arrays.copyOf(luckyNumbers, 2 * luckyNumbers.length);




    }
}
