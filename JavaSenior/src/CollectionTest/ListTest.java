package CollectionTest;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: Carl
 * @Date: 2021/02/10/19:50
 * @Description:
 * 一、List接口框架
 *      |----Collection接口：单列集合，用来储存一个一个的对象
 *          |----List接口：有序的、可重复的数据  ---- "动态数组" ---> 替换原有的数组
 *              |----ArrayList: JDK1.2出现，作为List接口的主要实现类；效率不安全，效率高；底层使用Object[] elementData储存
 *              |----LinkedList: JDK1.2出现；对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用双向链表存储
 *              |----Vector: JDK1.0出现，作为List接口的古老实现类；线程安全，效率低；底层使用Object[] elementData储存
 *
 *  问题：比较ArrayList、LinkedList、Vector三者的异同
 *  相同点：三个类都实现了List接口，存储数据的特点相同，存储有序的、可重复的数据
 *  不同点：见上
 *
 *  二、ArrayList源码分析：
 *  JDK7：
 *      ArrayList list = new ArrayList();   //底层创建了一个长度为10的Object类型数组elementData
 *      list.add(123);  //elementData[0] = new Integer(123);
 *      . . .
 *      list.add(11);   //如果此次的添加导致底层elementData数组容量不够，则进行扩容。默认情况下，扩容大小为原来容量的1.5倍，同时将原有数组中的元素拷贝到新的数组中
 *
 *      结论：建议开发中使用带参构造器：ArrayList list = new ArrayList(int capacity)
 *
 *  JDK8:
 *      ArrayList list = new ArrayList();   //底层Object[] elementData初始化为{}，并没有创建长度为10的数组
 *      list.add(123);  //第一次调用add()时，底层才创建了长度为10的数组，并将数据"123"添加到element[0]中
 *      . . 。
 *      后续的添加和扩容与JDK7相同
 *
 *  小结：JDK7中的ArrayList的创建类似于单例模式的饿汉式而JDK8中的ArrayList的对象的创建类似于单例的懒汉模式，延迟了数组的创建，节省内存。
 *
 *  三、LinkedList
 *      LinkedList list = new LinkedList(); //内部声明了Node类型的first和last属性，默认值为null
 *      list.add(123);  //将123封装到Node中，创建了Node对象
 *      其中Node定义为：体现了LinkedList的双向链表的说法
 *      private static class Node<E> {
 *          E item;
 *          Node<E> next;
 *          Node<E> prev;
 *
 *          Node(Node<E> prev, E element, Node<E> next) {
 *              this.item = element;
 *              this.next = next;
 *              this.prev = prev;
 *          }
 *      }
 *
 *  四、Vector源码分析：JDK7和JDK8中通过Vector()构造器构建对象时，底层创建了长度为10的数组。在扩容方面，默认扩容大小为原来数组长度的2倍。
 *
 *  五、List接口中的常用方法
 *
 *
 *
 */
public class ListTest {

    /*
    void add(int index, Object ele):在index位置插入ele元素
    boolean addAll(int index, Collection elements):从index位置开始将elements中的所有元素添加进来
    Object get(int index):获取指定index位置的元素
    int indexOf(Object obj):返回obj在集合中首次出现的位置
    int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
    Object remove(int index):移除指定index位置的元素，并返回此元素
    Object set(int index, Object element):设置指定index位置的元素为element
    List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合

    常用方法
    增：add(Object obj)
    删：remove(int index)/(Object obj)
    改：set(int index, Object element)
    查：get(int index)
    插：add(int index, Object element)
    遍历：1. Iterator迭代器方式
         2. 增强for循环
         3. 普通for循环
     */

    @Test
    public void test2(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add("abc");
        arrayList.add(new String("uio"));
        arrayList.add(new Person("Carl", 18));
        arrayList.add("abc");

        //方式一：迭代器方式
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("**********************************");

        //方式二：增强for循环
        for(Object obj : arrayList){
            System.out.println(obj);
        }


        System.out.println("**********************************");
        //方式三：普通for循环
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add("abc");
        arrayList.add(new String("uio"));
        arrayList.add(new Person("Carl", 18));
        arrayList.add("abc");

        System.out.println(arrayList);
        System.out.println();

        //void add(int index, Object element):在index位置插入element元素
        System.out.println("---------------------void add(int index, Object element)--------------------------");
        arrayList.add(1, "SS");
        System.out.println(arrayList);

        System.out.println();

        //boolean addAll(int index, Collection elements):从index位置开始将elements中的所有元素添加进来
        System.out.println("---------------------boolean addAll(int index, Collection elements)--------------------------");
        List<Integer> asList = Arrays.asList(1, 2, 3);
        arrayList.addAll(asList);
//        arrayList.add(asList);    //此操作会将asList中的所有元素视为一个元素添加进集合arrayList中
        System.out.println(arrayList.size());

        System.out.println();

        //Object get(int index):获取指定index位置的元素
        System.out.println("---------------------Object get(int index)--------------------------");
        System.out.println(arrayList.get(3));

        System.out.println();

        //int indexOf(Object obj):返回obj在集合中首次出现的位置，如果不存在则返回-1
        System.out.println("---------------------int indexOf(Object obj)--------------------------");
        int indexOf = arrayList.indexOf("abc");
        System.out.println(indexOf);

        System.out.println();

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        System.out.println("---------------------int lastIndexOf(Object obj)----------------------------");
        int lastIndexOf = arrayList.lastIndexOf("456");
        System.out.println(lastIndexOf);

        System.out.println();

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        System.out.println("---------------------Object remove(int index)----------------------------");
        Object remove = arrayList.remove(1);
        System.out.println(remove);

        System.out.println();

        //Object set(int index, Object element):设置指定index位置的元素为element
        System.out.println("---------------------Object remove(int index)----------------------------");
        Object set = arrayList.set(7, new Date());
        System.out.println(set);
        System.out.println(arrayList);

        System.out.println();

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的左闭右开区间子集合
        System.out.println("---------------------List subList(int fromIndex, int toIndex)----------------------------");
        List subList = arrayList.subList(2, 5);
        System.out.println(subList);

        System.out.println();
    }

}

class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
