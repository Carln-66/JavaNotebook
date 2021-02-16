package SetTest;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Auther: Carl
 * @Date: 2021/02/12/11:25
 * @Description:
 */
public class TreeSetTest {

    /*
    1. 向TreeSet中添加的数据，要求是相同类的对象
    2. 两种排序方式：自然排序(实现Comparable接口)和定制排序(实现Comparator)
    3. 自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()。
    4. 定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals()。
     */

    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        //错误，不能田间不同类的对象
//        set.add("164");
//        set.add("hzy");
//        set.add("lmx");
//        set.add(2333);
//        set.add(new Person("Tom", 18));

        set.add(18);
        set.add(65);
        set.add(-88);
        set.add(66);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        TreeSet treeSet = new TreeSet();
        treeSet.add("aks");
        treeSet.add("8989");
        treeSet.add("SSS");
        treeSet.add("测试");

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3(){
        TreeSet treeSet = new TreeSet();
        treeSet.add(new User("Tom", 16));
        treeSet.add(new User("LX", 18));
        treeSet.add(new User("abc", 33));
        treeSet.add(new User("LUX", 80));
        treeSet.add(new User("HII", -55));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test4(){
        Comparator comparator = new Comparator(){
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User user1 = (User) o1;
                    User user2 = (User) o2;
                    return Integer.compare(user1.getAge(), user2.getAge());
                } else {
                    throw new RuntimeException("输入输入年龄不匹配");
                }
            }
        };
        TreeSet set = new TreeSet(comparator);
        set.add(new User("Tom", 16));
        set.add(new User("LX", 18));
        set.add(new User("abc", 33));
        set.add(new User("LUX", 80));
        set.add(new User("HII", -55));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
