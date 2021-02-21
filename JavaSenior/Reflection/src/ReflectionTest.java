import exer.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: Carl
 * @Date: 2021/02/21/18:01
 * @Description:
 *  调用运行时类的指定结构：属性、方法、构造器
 */
public class ReflectionTest {

    //对属性要求过于严格，故而不需要掌握
    @Test
    public void testField() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class aClass = Person.class;

        //创建运行时类的对象
        Person p = (Person) aClass.newInstance();

        //获取指定的属性：要求运行时类的属性声明为public
        //由于属性值很少设置为public，因而如下方法通常不使用
        Field id = aClass.getField("id");

        //设置当前属性的值
        //set(): 参数1：指明设置哪个对象的属性    参数2：将此属性值设置为多少
        id.set(p, 1234);

        //获取当前属性的值
        int pId = (int) id.get(p);
        System.out.println(pId);
    }

    //如何获得运行时类中的指定的属性 -- 需要掌握
    @Test
    public void testField1() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class aClass = Person.class;

        //创建运行时类的对象
        Person p = (Person) aClass.newInstance();

        //1. getDeclaredField(String fieldName): 获取运行时类中指定变量名的属性
        Field name = aClass.getDeclaredField("name");

        //2. 保证当前属性是可访问的
        name.setAccessible(true);

        //3. 获取、设置指定对象的此属性值
        name.set(p, "李四");
        System.out.println(name.get(p));
    }

    //如何操作运行时类中的指定方法 -- 需要掌握
    @Test
    public void testMethod() throws Exception {
        Class aClass = Person.class;

        //创建运行时类的对象
        Person p = (Person) aClass.newInstance();

        //1. 获取指定的某个方法
        //getDeclaredMethod(): 参数1：指明获取的方法的名称   参数2：指明获取的方法的形参列表
        Method declaredMethod = aClass.getDeclaredMethod("show", String.class);

        //2. 保证当前方法是可访问的
        declaredMethod.setAccessible(true);

        //3. 调用invoke(): 参数1：方法的调用者  参数2：给方法形参赋值的实参
        //invoke()的返回值与对应类中调用的方法的返回值相同
        Object invoke = declaredMethod.invoke(p, "CHINA");  //String nation = p.show("CHINA")
        System.out.println(invoke);

        System.out.println("-------------调用静态方法--------------");

        Method showDesc = aClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值，则此invoke()返回null
        Object invoke1 = showDesc.invoke(Person.class);
        System.out.println(invoke1);
    }

    //如何调用运行时类中指定的构造器：实际中应用较少，原因是不具备通用性
    @Test
    public void testConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class aClass = Person.class;
        //private Person(String name)
        //1. 获取指定的构造器
        //getDeclaredConstructor(): 参数：指明构造器的参数列表
        Constructor constructor = aClass.getDeclaredConstructor(String.class);

        //2. 保证构造器是可访问的
        constructor.setAccessible(true);

        //3. 调用此构造器创建运行时类的对象
        Person person = (Person) constructor.newInstance("张三");
        System.out.println(person);
    }
}
