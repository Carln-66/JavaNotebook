package exer1;

import exer.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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

    /*
        获取运行时类的父类
     */
    @Test
    public void test2(){
        Class aClass = Person.class;
        Class superclass = aClass.getSuperclass();
        System.out.println(superclass);
    }

    /*
        获取运行时类的带泛型的父类
     */
    @Test
    public void test3(){
        Class aClass = Person.class;
        Type genericSuperclass = aClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    /*
        获取运行时类的带泛型的泛型

        代码：
        逻辑性代码
        功能性代码
     */
    @Test
    public void test4(){
        Class aClass = Person.class;

        Type genericSuperclass = aClass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
//        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class) actualTypeArguments[0]).getName());
    }

    /*
        获取运行时类实现的接口
     */
    @Test
    public void test5(){
        Class aClass = Person.class;
        Class[] interfaces = aClass.getInterfaces();
        for (Class c : interfaces){
            System.out.println(c);
        }

        //获取运行时类的父类实现的接口
        Class[] interfaces1 = aClass.getSuperclass().getInterfaces();
        for (Class c : interfaces1){
            System.out.println(c);
        }
    }

    /*
        获取运行时类所在的包
     */
    @Test
    public void test6(){
        Class aClass = Person.class;
        Package aPackage = aClass.getPackage();
        System.out.println(aPackage);
    }

    /*
        获取运行时类声明的注解
    */
    @Test
    public void test7(){
        Class aClass = Person.class;
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annos : annotations) {
            System.out.println(annos);
        }
    }
}
