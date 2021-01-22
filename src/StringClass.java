/***********************************
 字符串
 1. 提取字串
 利用String类下的substring可以从一个较大字符串中提取出子串。
 *substring方法中第二个参数是不想复制的第一个位置。
 * substring从0开始计数直至第n-1个字符结束
 *可以通过方法参数计算是。substring（a,b）子串长度为b-a

 2. 拼接
 字符串之间拼接用“+”，字符串可以用变量表示
 如果需要吧多个字符串放在一起，用一个界定符分割，可以使用静态join方法

 3. 不可变字符串
 由于不能修改Java字符串中的单个字符，所以在Java文档中将String类对象成为是不可变的（immutable）。

 4. 检测字符串是否相等
 使用equals方法检测两个字符串是否相等
 对于表达式
    s.equals(t)
 如果字符串s与字符串t相等，怎返回ture；否则返回false。
 * s和t可以是字符串变量，也可以是字符串字面量
 * 如"Hello"。equals（greeting）
 想要检测两个字符串是否相等，不区分大小写，可以使用equalsIgnoreCase方法。
 * 不能使用==运算符检测两字符串是否相等
 * ==所检测的是两个字符串是否在同一位置上

 5. 空串与Null串
 空串""是长度为0的字符串，用一下代码检查字符串是否为空
 可以调用以下代码检车字符串是否为空
        if (str. length() == 0)
 或
        if (str.equals(""))
 * 空串是一个Jav对象，有自己的串长度（0）和内容（空）
 * String变量还可以存放一个特殊的值，null，表示目前没有任何对象与该变量关联
 * 检查一个字符串是否为null，要使用以下条件
        if (str == null)
 有时要检查一个字符串既不是null也不是空船，这种情况下使用以下条件
        if (str != null && str.length() != 0)



 *
 */

public class StringClass {
    public static void main(String[] args) {
        String greeting = "hello";
        String s = greeting.substring(0,3);     //创建一个有字符'hel'组成的字符串
        System.out.println(s);                  //这里复制的位置是0，1，2个字符


        String all = String.join("/","S","M","L","XL");     //利用join方法以“/”分隔多个字符


        "Hello".equalsIgnoreCase("hello");       //利用equalsIgnoreCase方法检测字符串不区分大小写的情况下是否相等





    }
}
