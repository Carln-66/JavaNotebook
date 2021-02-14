package GenericTest.generic_class_test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/02/14/11:41
 * @Description: 定义泛型类、泛型接口、泛型方法
 *  1. 关于自定义泛型类、泛型接口
 *
 */
public class GenericTest1 {

    @Test
    public void test1(){

        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果定义的类时带泛型的，建议在实例化时要指明类的泛型
        Order order1 = new Order();
        order1.setOrderT("jdaso");
        order1.setOrderT(546);

        //实例化时指明泛型
        Order<String> order = new Order<String>("sad", 445, "happy");
        order.setOrderT("nervous");
    }

    @Test
    public void test2(){
        SubOrder subOrder = new SubOrder();
        //由于子类在继承带泛型的父类时指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        subOrder.setOrderT(7894);
    }

    @Test
    public void test3(){
        SubOrder1<Character> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT('L');
    }

    @Test
    public void test4(){
        //泛型不同的引用不能相互赋值
        ArrayList<String> arrayList1 = null;
        ArrayList<Integer> arrayList2 = null;

//        arrayList1 =arrayList2;
        //报错
//        Required type:ArrayList<String>
//        Provided:ArrayList<Integer>
    }

    @Test
    public void test5(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1, 5, 45, -7, 98};
        //泛型方法在调用时指明泛型参数的类型
        List<Integer> copy = Order.copyFromArrayToList(arr);
        System.out.println(copy);
    }
}
