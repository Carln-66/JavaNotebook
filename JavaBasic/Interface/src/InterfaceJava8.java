/**
 * @Auther: Carl
 * @Date: 2021/02/03/13:50
 * @Description: JDK8除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法
 */
public interface InterfaceJava8 {

    //静态方法
    public static void method1() {
        System.out.println("Compare -- 张三");
    }

    //默认方法
    public default void method2() {
        System.out.println("Compare -- 李四");
    }

    public default void method3() {
        System.out.println("Compare -- 王五");
    }

    public static void main(String[] args) {
        Subclass subclass = new Subclass();
//      subclass.method1();
//      接口中的静态方法只能通过接口来调用
        InterfaceJava8.method1();   //Compare -- 张三

        //通过实现类的对象，可以调用接口中的默认方法
        //如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
        subclass.method2();

        /*如果子类(或实现类)继承的父类实现的接口中声明了同名同参数的方法，那么子类在没有重写此方法的情况下，
         * 默认调用的时父类中的同名同参数的方法--->类优先原则*/
        /*如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，那么在实现类中没有重写此方法的
         * 情况下，报错。--->接口冲突
         * 这需要我们在实现类中必须重写此方法*/
        subclass.method3();
        System.out.println("****************************************");
        subclass.myMethod();
    }

}

class Subclass extends Superclass implements InterfaceJava8 {
    public void method2() {
        System.out.println("Subclass -- 小刘");
    }

    public void method3() {
        System.out.println("Subclass -- 小马");
    }

    //如何在子类(或实现类)的方法中调用父类、接口中被重写的方法
    public void myMethod() {
        method3();  //调用自己重写的方法
        super.method3();    //调用父类中重写的方法
        InterfaceJava8.super.method3();     //调用接口中的默认方法
    }
}

class Superclass {
    public void method3() {
        System.out.println("Superclass -- 小徐");
    }
}