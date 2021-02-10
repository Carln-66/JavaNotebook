package CollectionTest;

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
 *
 */
public class ListTest {
}
