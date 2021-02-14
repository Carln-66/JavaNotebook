package GenericTest;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: Carl
 * @Date: 2021/02/14/10:04
 * @Description: 泛型的使用
 * 1. JDK5.0新增特性
 * 2. 在集合中使用泛型
 *  1.1 集合接口或集合类在JDK5.0时都修改为带泛型结构
 *  1.2 在实例化Collection类时，可以指明具体的泛型类型
 *  1.3 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构(比如方法、构造器、属性等)使用到类的泛型的位置，都指定为实例化的泛型类型
 * 例如add(E e) ---> 实例化以后：add(Integer e)
 *  1.4 泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，使用包装类替换。
 *  1.5 如果没有指明泛型的类型，默认类型为java.lang.Object类型
 * 3. 如何自定义泛型结构：泛型类、泛型接口；泛型方法。见GenericTest1.java
 *
 */
public class GenericTest {

    //集合中使用泛型之前的情况
    @Test
    public void test1() {
        ArrayList arrayList = new ArrayList();
        //需求：存放学生成绩
        arrayList.add(89);
        arrayList.add(88);
        arrayList.add(65);
        arrayList.add(97);
        arrayList.add(92);
        arrayList.add(100);

        //问题一：类型不安全
        arrayList.add("ABC");

        //问题二：强转时，可能出现ClassCastException
        for (Object score : arrayList) {
            int studentScore = (Integer) score;
            System.out.println(studentScore);
        }
    }

    //集合中使用泛型之前的情况
    @Test
    public void test2() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(123);
        arrayList.add(45);
        arrayList.add(189);
        arrayList.add(357);

        //编译时，就会进行类型检查，保证数据的安全
//        arrayList.add("ooo");

        //方式一
//        for (Integer score : arrayList){
//            //避免了强转操作
//            int stuScore = score;
//            System.out.println(stuScore);
//        }

        //方式二
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
    }

    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3() {
//        Map<String, Integer> map = new HashMap<String, Integer>();
        //JDK1.7后新特性：类型推断：new后类名中可以不写泛型
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 18);
        map.put("Kate", 28);
        map.put("Jerry", 36);
        map.put("Jack", 9);

        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + " ---> " + value);
        }
    }
}
