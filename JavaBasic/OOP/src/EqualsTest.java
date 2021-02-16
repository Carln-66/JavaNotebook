/**
 *              面试题：==和Equals的区别
 *
 *              一、回顾 == 的使用
 *                  ==：运算符
 *              1. 可以使用在基本数据变量和引用数据类型变量中
 *              2. 如果比较的是基本数据类型变量，比较两个变量保存的数据是否相等(不一定类型要相同)
 *                  如果比较的是引用数据类型对象，比较两个变量的地址值是否相等。
 *
 *              二、equals()方法的使用
 *              1. 是一个方法，而非运算符
 *              2. 只能适用于引用数据类型
 *              3. Object类中equals()的定义：
 *                      public boolean equals(Object obj){
 *                              return (this == obj);
 *                      }
 *                  说明：Object类中定义的equals()和==作用是相同的，比较两个对象的地址值是否相同，即连哥哥引用是否指向同一个地址值。
 *              4. 像String、Date、File、包装类等都重写了Object类中的equals()方法。重写以后比较的不是两个引用的地址是否相同，而是
 *                  两个对象的"实体内容"是否相同。
 *              5. 通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个"实体内容"是否相同。那么，我们就需要对Object类中
 *                  的equals()方法进行重写。
 *
 *
 */
public class EqualsTest {
    public static void main(String[] args) {
         int i = 10;
         int j = 10;
         double k = 10.0;
        System.out.println(i == j);     //true
        System.out.println(i == k);     //true
    }
}
