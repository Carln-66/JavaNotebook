package CollectionTest.Map;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: Carl
 * @Date: 2021/02/12/21:26
 * @Description:
 *  一、Map实现类的结构
 *      /----Map: JDK1.2出现；双列数据，储存key-value对的数据   ---类似于高中的函数 y = f(x)
 *          /----HashMap: JDK1.2出现；作为Map的主要实现类；线程不安全，效率高；存储null的key和value
 *              /----LinkedHashMap: JDK1.4出现；保证在遍历map元素时，可以按照添加的顺序实现遍历
 *                                  原因：在原有的HashMap底层架构基础上，添加了一对指针，指向前一个和后一个元素。
 *                                  对于频繁的遍历操作，此类执行效率高于HashMap
 *          /----TreeMap: JDK1.2出现；保证按照添加的key-value对齐进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 *                        底层使用红黑树
 *          /----Hashtable: JDK1.0出现；作为古老的实现类；线程安全，效率低；不能存储null的key和value
 *              /----Properties: 常用来处理配置文件。key和value都是String类型
 *
 *      HashMap底层：
 *          JDK7：数据+链表
 *          JDK8：数组+链表+红黑树
 *
 *      题目：
 *      1. HashMap的底层实现原理：
 *
 *      2. HashMap和HashTable的异同：
 *
 *      3. CurrentHashMap与Hashtable的异同：
 *
 *  二、Map结构的理解
 *      Map中的key：无序的，不可重复的。使用Set存储所有的key    --->key所在的类需要重写equals()和hashCode() (以HashMap为例)
 *      Map中的value：无序的，可重复的，使用Collection储存所有的value      --->value所在的类要重写equals()
 *      一个键值对(key-value)构成了一个Entry对象。
 *      Map中的entry：无序的、不可重复的，使用Set存储所有的Entry
 *
 *  三、HashMap的底层实现原理
 *      JDK7：
 *      HashMap map = new HashMap();   //在实例化以后，底层创建了长度为16的一维数组Entry[] table
 *      ...可能已经执行过多次put...
 *      map.put(key1,value1);
 *      首先，调用key1所在类的hashCode()计算key1的哈希值，此hash值经过某种算法计算以后，得到在Entry数组中的存放位置
 *      如果此位置上的数据为空，此时key1-value1(Entry)添加成功。   ----> 情况一
 *      如果此位置上的数据不为空(意味着此位置上存在一个或多个数据；多个的话以链表形式存在)，比较key1和已经存在的一个或多个数据的哈希值
 *          如果key1的哈希值与已经存在的数据哈希值都不相同，此时key1-value1(即Entry)添加成功。    ----> 情况二
 *          如果key1的哈希值与已经存在的某一个数据(key2-value2)的哈希值相同，继续调用key1所在类的equals()方法，比较内容是否相同
 *              如果equals()返回false：此时key1-value1(即Entry)添加成功。    ----> 情况三
 *              如果equals()返回true：使用value1替换相同key的value2值
 *
 *      补充：关于情况二和情况三：此时key1-value1和原来的数据以链表的形式存储。
 *
 *      在不断的添加过程中，会涉及到扩容问题，默认的扩容方式：当超出临界值并且添加的位置非空时，扩容为原来容量的2倍，并将原有数据复制过来。
 *
 *      JDK8相较于JDK7在底层实现方面的不同：
 *      1. new HashMap(): 底层没有创建一个长度为16的数组
 *      2. JDK8底层的数组时Node[], 而非Entry[]
 *      3. 首次调用put()方法时，底层创建长度为16的数组
 *      4. JDK7底层结构只有数组+链表；JDK8中底层结构为数组+链表+红黑树
 *          当数组的某一个索引位置上的元素以链表形式存在的数据个数大于8，且当前数组的长度大于64时，此时索引位置上的所有数据改为用红黑树存储。
 *
 *      DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 *      MAXIMUM_CAPACITY ： HashMap的最大支持容量，2^30
 *      DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
 *      TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树：8
 *      UNTREEIFY_THRESHOLD：Bucket中红黑树存储的Node小于该默认值，转化为链表
 *      MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量。（当桶中Node的数量大到需要变红黑树时，若hash表容量小于MIN_TREEIFY_CAPACITY时，此时应执行resize扩容操作这个MIN_TREEIFY_CAPACITY的值至少是TREEIFY_THRESHOLD的4倍。）：64
 *      table：存储元素的数组，总是2的n次幂
 *      entrySet：存储具体元素的集
 *      size：HashMap中存储的键值对的数量
 *      modCount：HashMap扩容和结构改变的次数。
 *      threshold：扩容的临界值，=容量*填充因子：16*0.75=12
 *      loadFactor：填充因子
 *
 *  四、LinkedHashMap底层实现原理
 *  源码中
 *      static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;    //能够记录添加元素的先后顺序
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 *  五、Map中定义的方法
 *  添加、删除、修改操作：
 *   Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *   void putAll(Map m):将m中的所有key-value对存放到当前map中
 *   Object remove(Object key)：移除指定key的key-value对，并返回value
 *   void clear()：清空当前map中的所有数据
 *  元素查询的操作：
 *   Object get(Object key)：获取指定key对应的value
 *   boolean containsKey(Object key)：是否包含指定的key
 *   boolean containsValue(Object value)：是否包含指定的value
 *   int size()：返回map中key-value对的个数
 *   boolean isEmpty()：判断当前map是否为空
 *   boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元视图操作的方法：
 *   Set keySet()：返回所有key构成的Set集合
 *   Collection values()：返回所有value构成的Collection集合
 *   Set entrySet()：返回所有key-value对构成的Set集合
 *
 *  总结常用方法：
 *  增加：put(Object key, Object value)
 *  删除：remove(Object key)
 *  修改：put(Object key, Object value)
 *  查询：get(Object key)
 *  长度：size()
 *  遍历：keySet()/values()/entrySet()
 *
 *
 *
 */
public class MapTest {

    //元视图操作的方法
    @Test
    public void test5(){
        Map map = new HashMap();
        map.put("QA", 159);
        map.put("LS", 33);
        map.put("ZS", 296);
        map.put("QA", 140);

        //遍历所有的key集：keySet
        Set set = map.keySet();
        System.out.println(set);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("*******************************");

        //遍历所有的value集：values()
        Collection values = map.values();
        for (Object obj : values){
            System.out.println(obj);
        }

        System.out.println("*******************************");

        //遍历所有的key-value：entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object next = iterator1.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

    }


    //元素查询
    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("QA", 159);
        map.put("LS", 33);
        map.put("ZS", 296);
        map.put("QA", 140);

        HashMap map1 = new HashMap();
        map1.put("LS", 33);
        map1.put("ZS", 296);
        map1.put("QA", 140);

        //Object get(Object key)
        System.out.println(map.get("ZS"));

        //containsKey(Object key)
        boolean containsKey = map.containsKey("PO");
        System.out.println(containsKey);

        //containsValue()
        boolean containsValue = map.containsValue(140);
        System.out.println(containsValue);

        //size()
        System.out.println(map.size());

        //isEmpty()
        System.out.println(map.isEmpty());

        //equals(Object)
        boolean equals = map.equals(map1);
        System.out.println(equals);
    }

    //增删改
    @Test
    public void test3(){
        //添加
        Map map = new HashMap();
        map.put("QA", 159);
        map.put("LS", 33);
        map.put("ZS", 296);
        map.put("QA", 140);
        //修改
        System.out.println(map);

        HashMap map1 = new HashMap();
        map1.put("SS", 24);
        map1.put("RA", 987);
        map1.put("LA", 6);

        map.putAll(map1);
        System.out.println(map);

        //remove(Object key)
        Object remove = map.remove("LS");
        System.out.println(remove);

        //clear()
        map.clear();    //与map = null不同
        System.out.println(map.size()); //0
    }

    @Test
    public void test2(){
        Map map = new HashMap();
        map = new LinkedHashMap();
        map.put(456, "SS");
        map.put(777, "abc");
        map.put(365, "kls");
        map.put(05, "ak");
        map.put(47, "zcx");

        System.out.println(map);

    }

    @Test
    public void test1(){
        HashMap hashMap = new HashMap();
//        Hashtable hashtable = new Hashtable();
        hashMap.put(null, null);
    }
}
