package CollectionTest.Map;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: Carl
 * @Date: 2021/02/13/11:19
 * @Description:
 *
 *
 *
 *
 */
public class TreeMapTest {

    /*
    向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    因为要按照key进行排序：自然排序、定制排序
     */
    //自然排序
    @Test
    public void test1(){
        TreeMap treeMap = new TreeMap();
        User user1 = new User("LMX", 3);
        User user2 = new User("HZY", 4);
        User user3 = new User("XXX", 50);
        User user4 = new User("ABC", 26);

        treeMap.put(user1, 99);
        treeMap.put(user2, 128);
        treeMap.put(user3, 632);
        treeMap.put(user4, 9);

        Set entrySet = treeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

    //定制排序
    @Test
    public void test2(){




        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User user1 = (User) o1;
                    User user2 = (User) o2;
                    return Integer.compare(user1.getAge(), user2.getAge());
                }
                throw new RuntimeException("输入数据类型不匹配");
            }
        });
        User user1 = new User("LMX", 3);
        User user2 = new User("HZY", 4);
        User user3 = new User("XXX", 50);
        User user4 = new User("ABC", 26);

        treeMap.put(user1, 99);
        treeMap.put(user2, 128);
        treeMap.put(user3, 632);
        treeMap.put(user4, 9);

        Set entrySet = treeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }
}
