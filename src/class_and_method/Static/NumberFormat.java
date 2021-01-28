package class_and_method.Static;

/******************
    4. 工厂方法
    静态方法还有另外一种常见的用途，类似LocalDate.now和LocalDate.of。
    NumberFormat类如下生成不同风格的格式化对象

    NumberFormat类不需要利用构造器完成这些操作，原因有二
 *  无法命名构造器。构造器的名字必须与类名相同，但是这里希望有两个不同的名字，分别得到货币实例和百分比实例
 *  使用构造器时，无法改变所构造对象的类型。而工厂方法实际上将返回DecimalFormat类的对象，这是NumberFormat的一个子类

    5. main方法
    要注意的是，可以调用静态方法而不需要任何对象。例如不需要构造Math类的任何对象就可以调用Math.pow。
 同理，main方法也是一个静态方法。
        public class Application
        {
            public static void main(String[] args) {
                //construct objects here
                . . .
            }
        }
 *   main方法不对任何对象进行操作。
 *  事实上，在启动程序时还没有任何对象。静态的main方法将执行并构造程序所需要的对象。
 */

public class NumberFormat {
    public static void main(String[] args) {
        java.text.NumberFormat currencyFormatter = java.text.NumberFormat.getCurrencyInstance();
        java.text.NumberFormat percentFormatter = java.text.NumberFormat.getPercentInstance();
        double x = 0.1;
        System.out.println(currencyFormatter.format(x));    //打印 $0.10
        System.out.println(percentFormatter.format(x));     //打印 10%
    }
}
