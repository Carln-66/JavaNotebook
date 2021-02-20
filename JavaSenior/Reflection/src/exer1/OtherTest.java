package exer1;

import exer.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Auther: Carl
 * @Date: 2021/02/21/0:42
 * @Description:
 */
public class OtherTest {
    //获取构造器结构
    @Test
    public void test1() {
        Class aClass = Person.class;
        //getConstructors(): 获取当前运行时类中声明为public的构造器
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);

            System.out.println();

            //getDeclaredConstructors(): 获取当前运行时类中声明的所有构造器
            Constructor[] declaredConstructors;
            declaredConstructors = aClass.getDeclaredConstructors();
            for (Constructor c1 : declaredConstructors) {
                System.out.println(c1);
            }
        }
    }
}
