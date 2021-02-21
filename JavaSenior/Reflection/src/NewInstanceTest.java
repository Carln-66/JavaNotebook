import org.junit.Test;
import reflection.Person;

import java.util.Random;

/**
 * @Auther: Carl
 * @Date: 2021/02/20/18:50
 * @Description:
 * 通过反射创建对应的运行时类对象
 */
public class NewInstanceTest {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> aClass = Person.class;

        /*
            newInstance(): 调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器

            要想此方法能够正常创建运行时类的对象，要求：
            1. 运行时类必须提供空参的构造器
            2. 提供满足条件的空参构造器权限修饰符。通常置为public。

            在javabean种要求提供一个public的空参构造器。原因：
            1。 便于通过反射创建运行时类的对象
            2. 便于子类继承此运行类时，默认调用super()时，保证父类有此构造器
         */
        Person p1 = aClass.newInstance();       //造运行时类的对象绝大多数情况都是调用此方法
        System.out.println(p1);
    }

    //体会反射的动态性
    @Test
    public void test2() {

        for (int i = 0; i < 100; i++) {

            int num = new Random().nextInt(3);    //0,1,2
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "reflection.Person";
                    break;
            }

            Object instance = null;
            try {
                instance = getInstance(classPath);
                System.out.println("i---" + i + "   " + instance);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    //创建一个指定类的对象
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class aClass = Class.forName(classPath);
        return aClass.newInstance();
    }
}
