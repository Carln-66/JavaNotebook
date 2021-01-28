package OOP;

/*
 *          面向对象的特征之一：封装与隐藏
 *      一、问题引入
 *          当我们创建一个类的对象以后，我们可以通过"对象.属性"的方式，对对象的属性进行赋值。这里，赋值操作才做要受到属性的数据类型和存储范围的制约。
 *        除此之外，没有其他制约条件。但是在实际问题中，我们往往需要给属性赋值加入额外的限制条件。这个条件不能在属性声明时体现。我们只能通过方法进行限
 *        制条件的添加(比如setLegs())。同时，我饿们需要避免用户再次使用"对象.属性"的方式进行复制。则需要将属性声明为私有的(private)。
 *        ---> 此时，针对于属性就体现了封装性
 *      二、封装性的体现
 *          我们将类的属性私有化(private)，同时，提供公共的public方法来获取(getXxx)和设置(setXxx)此属性的值。
 *
 *      封装性的体现
 *          ① 属性私有化
 *          ② 不对外暴露的私有的方法
 *          ③ 单例模式...
 *
 *      三、封装性的体现，需要权限修饰符来配合
 *          1. Java规定的4种权限(从小到大排列): private、缺省(default)、protected、public
 *          2. 4种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类
 *              修饰类只能用public或缺省
 */

public class AnimalTest {

    public static void main(String[] args) {
        Animal a = new Animal();
        a.setLegs(3);

        a.show();
    }
}

class Animal{
    private String name;
    private int age;
    private int legs;

    //对属性的设置
    public void setLegs(int i){
        if (1 >= 0 && i % 2 ==0){
            legs = 1;
        }else {
            legs = 0;
        }
    }

    //对属性的获取
    public int getLegs(){
        return legs;
    }

    public void eat(){
        System.out.println("动物进食");
    }
    public void show(){
        System.out.println("name = " + name + ", age = " + age + ", legs = " + legs);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int a) {
        age = a;
    }
}
