package ObjectConstruction;

/****************************
 7. 初始化块
 两种初始化数据字段的方法
 * 在构造器中设置值
 * 在声明中赋值
 实际Java还有第三种机制，称为初始化块(initialization block)。在一个类的声明中，可以包含任意多个代码块。
 只要构造这个类的对象，这些块就会被执行。例如，
    class Employee
    {
        private static int nextId;

        private int id;
        private String name;
        private double salary;

        //对象初始化块
        {
            id = nextId;
            nextId++;
        }

        public Employee(String n, double s)
        {
            name = n;
            salary = s;
        }

        public Employee()
        {
            name = "";
            salary = 0;
        }
        . . .
    }
 在这个实例中，无论哪个构造器构造对象，id字段都会在对象初始化块中初始化。首先运行初始化块，然后才运行构造器的主体部分。
 这种机制不是必须的，也不常见。通常会直接将初始化代码放在构造器中。

 由于初始化数据字段有多种途径，所以列出构造过程的所有路径可能让人困惑，下面是调用构造器的具体处理步骤：
 ① 如果构造器的第一行调用了另一个构造器，则基于所提供的参数执行第二个构造器。
 ② 否则，
    a) 所有数据字段初始化为其默认值(0,false或null)
    b) 按照在类声明中出现的顺序，执行所有字段初始化方法和初始化块
 ③ 执行构造器主体代码

 可以通过提供一个初始值，或者使用一个静态的初始化块来初始化静态字段。前面已经介绍过第一种机制：
    private static int nextId = 1;
 如果类的静态字段需要很复杂的初始化代码，那么可以使用静态的初始化块。
 将代码放在一个块中，并标记关键字static。下面的例子功能是将员工ID的七十至赋予一个小于10000的随机整数。
    static
    {
        var generator = new Random();
        nexId = generator.nextInt(10000);
    }
 在类第一次加载的时候，将会进行静态字段的初始化。与实例字段一样，除非将静态字段显式的设置成其他值，
 否则默认的初始值是0，false或null。所有静态字段初始化方法以及静态初始化块都将依照声明中出现的顺序执行。
 */


public class InitializationBlock {
}
