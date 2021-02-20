package reflection;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Auther: Carl
 * @Date: 2021/02/20/13:44
 * @Description:
 */
public class ReflectionTest {

    //反射之前，对于Person的操作
    @Test
    public void test1(){

        //1. 实例化Person类
        Person p1 = new Person("张三", 16);

        //2. 调用其内部属性和方法
        p1.age = 10;
        System.out.println(p1);

        p1.show();

        //在Person类外部，不能够通过Person类的对象调用其私有的结构。
        //比如：name、showInfo()以及私有的构造器
    }

    @Test
    public void test2() throws Exception {
        Class<Person> aClass = Person.class;
        //1. 通过反射创建Person类的对象
        Constructor<Person> aClassConstructor = aClass.getConstructor(String.class, int.class);
        Person person = aClassConstructor.newInstance("张三", 16);
        System.out.println(person);

        //2. 通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = aClass.getDeclaredField("age");
        age.set(person, 10);
        System.out.println(person);

        //调用方法
        Method show = aClass.getDeclaredMethod("show");
        show.invoke(person);

        System.out.println("····················调用私有结构·························");

        //通过反射可以调用Person类的私有结构。比如私有的构造器、方法、属性
        //调用私有的构造器
        Constructor cons1 = aClass.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("李四");
        System.out.println(p1);

        //调用私有的属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "王五");
        System.out.println(p1);

        //调用私有的方法
        Method showInfo = aClass.getDeclaredMethod("showInfo", String.class);
        showInfo.setAccessible(true);
        String info = (String) showInfo.invoke(p1, "测试");
        System.out.println(info);
    }

    //通过new的方式或反射方式都可以调用公共结构，开发中到底用什么
    //建议直接new
    //什么时候使用反射？     反射的特征：动态性
    //疑问：反射机制与面向对象中的封装性是否矛盾？如何看待？
    //不矛盾。

    /*
        关于java.lang.Class类的理解
        1. 类的加载过程：程序经过javac.exe命令后，会生成一个或多个字节码文件(.class结尾)，接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程称为类的加载。加载到内存中的类被称为运行时类，此运行时类就作为Class的一个实例。

        2. 换句话说，Class的实例就对应着一个运行时类。
        3. 加载到内存中的运行时类，会缓存一定时间。再此时间内，可以通过不同的方式来获取此运行时类。
     */

    //获取Class实例的方式
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性: .class
        Class<Person> aClass1 = Person.class;
        System.out.println(aClass1);

        //方式二：通过运行时类的对象，调用getClass()方法
        Person p1 = new Person();
        Class<? extends Person> aClass2 = p1.getClass();
        System.out.println(aClass2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class<?> aClass3 = Class.forName("reflection.Person");
        System.out.println(aClass3);

        System.out.println(aClass1 == aClass2);
        System.out.println(aClass1 == aClass3);

        //*使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class aClass4 = classLoader.loadClass("reflection.Person");
        System.out.println(aClass4);
    }

    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);

    }


}
