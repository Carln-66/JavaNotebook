package interface_test;

/**
 * @Auther: Carl
 * @Date: 2021/02/03/11:05
 * @Description: 接口
 * 接口的使用
 * 1. 接口使用interface来定义
 * 2. Java中，接口和类是并列的两个结构
 * 3. 如何定义接口：定义接口中的成员
 * 3.1 JDK7以前：只能定义全局常量和抽象方法
 * > 全局常量：public static final(但是，书写时可以省略不写)
 * > 抽象方法：public abstract
 * <p>
 * <p>
 * <p>
 * 3.2 JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法
 * 4. 接口中不能定义构造器！这意味着接口不能实例化。
 * 5. Java开发中，接口都通过让类去实现(implements)的方式使用。
 * 如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化。
 * 如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类
 * 6. Java类可以实现多个接口--->弥补了Java单继承性的局限
 *      格式： class AA extends BB implements CC, DD, EE...
 * 7. 接口与接口之间可以继承，且可以多继承
 * *********************************************
 * 8. 接口的具体使用：体现多态性
 * 9. 接口实际上可看做是一种规范
 */
public class InterfaceTest {
    public static void main(String[] args) {

        Plane plane = new Plane();
        plane.fly();

    }
}

interface Flyable {
    public static final int MAX_SPEED = 7900;
    int MIN_SPEED = 1;  //省略了public static final

    public abstract void fly();

    //省略了public abstract
    void stop();
}

class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("飞机起飞");
    }

    @Override
    public void stop() {
        System.out.println("飞机降落");
    }
}

abstract class Kite implements Flyable {

    @Override
    public void fly() {

    }
}