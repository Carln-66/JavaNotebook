package GenericTest.generic_class_test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/02/14/11:35
 * @Description: 自定义泛型类
 */
public class Order<T> {
    String orderName;
    int orderId;

    //当类中有一个属性不确定时，可以使用泛型，那么类的内部结构可以使用类的泛型
    T orderT;

    public Order() {
    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    //如下三个方法不是泛型方法
    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    //静态方法中不能使用类的泛型
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
    //换而言之，泛型方法所属的类是不是泛型类都没有关系
    //泛型方法是可以声明为静态的。原因：泛型参数是在第哦啊用方法时确定的，并非在实例化时确定
    public static  <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for (E e : arr){
            list.add(e);
        }
        return list;
    }
}
