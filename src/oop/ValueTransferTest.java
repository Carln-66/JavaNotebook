package oop;

/*
 *          关于变量的赋值
 *  如果变量是基本数据类型，此时赋值的是变量所保存的数据值
 *  如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值
 *
 *          方法形参的传递值，值传递
 *      1. 形参：方法定义时，声明的小括号的值
 *         实参：方法调用时，实际传递给形参的数据
 *
 *      2. 值传递机制：
 *          如果参数是基本数据类型，此时实参赋给形参的是实参真实存储的数据值
 *          如果参数是引用数据类型，此时实参实参赋给形参的是实参保存数据的地址值
 */

public class ValueTransferTest {
    public static void main(String[] args) {
        System.out.println("**************************基本数据类型**************************");
        int m = 10;
        int n = m;
        System.out.println("m = " + m + ", n = " + n);

        n = 20;
        System.out.println("m = " + m + ", n = " + n);

        System.out.println("**************************引用数据类型**************************");

        Order o1 = new Order();
        o1.orderId = 1001;

        Order o2 = o1;
        System.out.println("o1.orderId = " + o1.orderId + "  o2.orderId = " + o2.orderId);

        o2.orderId = 1002;
        System.out.println("o1.orderId = " + o1.orderId + "  o2.orderId = " + o2.orderId);

    }
}
class Order{
    int orderId;
}