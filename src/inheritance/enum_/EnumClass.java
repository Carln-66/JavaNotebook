package inheritance.enum_;

import java.util.Scanner;

/**********************************************************
 枚举类
 典型例子
    public enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE}
 这个声明定义的类型是一个类，它有4个实例，不可能构造新的对象。
 因而再比较两个枚举类型的值时，并不需要调用equals，直接使用"=="就可以。如果需要的话，可以为枚举类型增加构造器，方法和字段。
 构造器只是在构造枚举常量的时候调用。
    public enum Size
    {
        SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

        private String abbreviation;

        private Size(String abbreviation) { this.abbreviation = abbreviation; }
        public String getAbbreviation() { return abbreviation; }
    }
 枚举的构造器总是私有的。可以像强力中一样省略private修饰符。如果声明一个enum构造器为public或protected，会出现语法错误。
 所有枚举类型都是Enum类的子类。他们继承了这个类的许多方法。其中最有用的一个是toString，这个方法会返回枚举常量名。
 例如，Size,SMALL.toString( )将返回字符串"SMALL"。
 toString的逆方法是静态方法valueOf。例如以下语句：
    Size s = Enum.valueOf(Size.class,"SMALL");
 将s设置成Size.SMALL。
 每个枚举类型都有一个静态的values方法，它将返回一个包含全部枚举值的数组。例如如下调用：
    Size[] values = Size.values();
 返回包含元素Size.Values();
 返回包含元素Size.SMALL，Size.MEDIUM，Size.LARGE和Size.EXTRA_LARGE的数组。
 ordinal方法返回enum声明中枚举常量的位置，位置从0开始技术。例如：Size.MEDIUM.ordinal（）返回1。
 */

public class EnumClass {

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase();

        Size size = Enum.valueOf(Size.class, input);    //返回给定类中有指定名字的枚举常量

        System.out.println("size = " + size);
        System.out.println("abbreviation = " + size.getAbbreviation());

        if (size == Size.EXTRA_LARGE)
            System.out.println("Good job--you paid attention to the _.");
    }
}
