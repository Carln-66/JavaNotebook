package questiontest;

import org.junit.Test;

import java.util.HashSet;

/**
 * @Auther: Carl
 * @Date: 2021/02/12/17:57
 * @Description:
 */
public class QuestionTest {

    @Test
    public void test1(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);
        /*
        [Person{id=1002, name='BB'}, Person{id=1001, name='CC'}]  因为此时"1001,CC"所存的位置是原本"1001,AA"通过哈希值计算得到的位置，remove()方法将"AA"移除但并未移动其hash值地址。所以此时set中仍然有两个元素。
         */

        set.add(new Person(1001,"CC"));
        System.out.println(set);
        /*
        将"1001.CC"存入set中，首先计算哈希值确定存储的具体位置，之前的"1001,CC"所存的位置其实是"1001,AA"的位置，两个地址并不相同。
         */

        set.add(new Person(1001,"AA"));
        System.out.println(set);
        /*
        将"1001,AA"存入set中，首先计算哈希值确定存储的具体索引，此时查询到该位置有"1001,CC"，通过equals()方法比较两集合中元素具体内容不相同，进而与其形成链表，两个内容都可以加进集合中。
         */

    }
}
