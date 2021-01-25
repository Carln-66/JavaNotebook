package Inheritance;

/**************************************
 5. 多态
 有一个简单的规则可以用来判断是否应该将数据设计为继承关系，就是"is-a"规则。他指出子类的每一个对象也是超类的对象。例如，每个经理都是员工，因此，将Manager类设计成为Employee类的子类是有道理的，反之则不然。
 "is-a"规则的另一种表述是替换原则(substitution principle)。他指出程序中出现超类对象的任何地方都可以使用子类对象替换。
 例如，可以将子类的对象赋给超类变量
    Employee e;
    e = new Employee(. . .);    //Employee object expected
    e = new Manager(. . .);     //OK,Manager can be used as well
 在Java程序设计语言中对象变量是多态的(polymorphic)。一个Employee类型的变量既可以引用一个Employee类型的对象，也可以引用Employee类的任何一个子类的对象(例如：Manager/Executive/secretary等)。
 在下程序中，我们利用了这个替换原则：
    Manager boss = new Manager(. . .);
    Employee[] staff = new Employee[3];
    staff[0] = boss;
 上述例子中，变量staff[0]与boss引用同一对象。但编译器只将staff[0]看成一个Employee对象
 这意味着，可以这样调用
    boss.setBonus(5000);    //OK
 但不能这样调用
    staff[0].setBonus(5000);    //Error
 原因是staff[0]声明的类型是Employee，而setBonus不是Employee类的方法。
 不过，不能将超类的引用赋给子类变量。例如下面的赋值是非法的：
    Manager m = staff[i];       //Error
 原因很清楚：不是所有的员工都是经理，如果复制成功，m有可能引用了一个不是经理的Employee对象，而在后面有可能忽地奥永m.setBonus(...)，这就会发生运行时错误。

 * 在Java中，子类引用的数组可以转换成超类引用的数组，而不需要使用强制类型转换。例如下面是一个经理数组
 *      Manager[] managers = new Manager[10];
 * 将他转换成Employee[]数组是完全合法的。
 *      Employee[] staff = managers;    //OK

 6. 理解方法调用
 如何准确理解在对象上应用方法调用？
 下面假设要调用x.f(args)，隐式参数x声明为类C的一个对象。下面是调用过程的详细面熟
 * 编译器查看对象的声明类型和方法名。需要注意的是：有可能存在多个名字为f单参数类型不一样的方法。例如，可能存在方法f(int)和方法f(String)。编译器将会一一列举额类中所有名为f的方法和其超类中所有名为f而且可以访问的方法(超类的私有方法不可访问)。
 至此，编译器一直到所有可能被调用的候选方法。
 * 接下来，编译器要确定方法中提供的参数类型。如果在所有名为f的方法中存在一个与所提供参数类型完全匹配的方法，就选择这个方法。这个过车更成为重载解析(overloading resolution)。例如，对于x.f("Hello")，编译器将会挑选f(String)，而不是f(int)。由于允许类型转换（int可以转换成double，Manager可以转换成Employee，等等），所以情况可能会变得更复杂。如果编译器没有找到与参数类型匹配的方法，或者发现经过类型转换后有多个方法与之匹配，编译器就会报告一个错误。
 至此，编译器已经知道需要调用的方法的名字和参数类型。

 前面曾说过，方法的名字和参数列表称为方法的签名。例如f(int)和f(String)是两个具有相同名字，不同签名的方法。如果在子类中定义了一个与超类签名相同的方法，那么子类中的这个方法就会覆盖超类中这个相同签名的方法。
 返回类型不是签名的一部分。不过再覆盖一个方法是，需要保证返回类型的兼容性。允许子类将覆盖方法的返回类型改为原返回类型的子类型。例如，Employee类有以下方法：
    public Employee getBuddy(){. . .}
 经理不会想找这种底层员工作搭档。为了反应这一点，在子类Manager中，可以如下覆盖这个方法：
    public Manager getBuddy(){. . .}    //OK to change return type
 我们说，这两个getBuddy方法有可协变的返回类型。

 * 如果是private方法，static方法，final方法或者构造器，那么编译器将可以准确的知道应该调用哪种方法。这称为静态绑定(static binding)。与此对应的是，如果要调用的方法依赖于隐式参数的实际类型，那么必须在运行时使用动态绑定。
 * 程序运行并且采用动态绑定调用方法时，虚拟机必须调用与x所引用对象的实际类型对应的那个方法。假设x的实际类型是D，他是C类的子类。如果D定义了方法f(String)，就会调用这个方法；否则，将在D类的超类中寻找f(String)，以此类推。
 每一次调用方法都要完成搜索，时间开销相当大。因此，虚拟机预先为每个累计算了一个方法表(method table)，其中列出了所有方法的签名和要调用的实际方法。这样一来，在真正调用方法的时候，虚拟机仅查找这个表就行了。在前面的例子中，虚拟机搜索D类的方法表，寻找调用f(String)相匹配的方法。这个方法既有可能是D.f(String)，也有可能是X.f(String)，这里的X是D的某个超类。需要注意的是，如果调用是super.f(param)，那么编译器将对隐式参数超类的方法表进行搜索。

 现在来分析ManagerTest.java中调用e.getSalary()的过程。e声明为Employee类型。Employee类只有一个名叫getSalary的方法，这个方法没有参数。因此在这里不用担心重载解析的问题。
 由于getSalary不是private方法，static方法或final方法，所以采用动态绑定。虚拟机为Employee和Manager类生成方法表。在Employee的方法表中列出了Employee类本身定义的所有方法
    Employee:
        getName() -> Employee.getName()
        getSalary() -> Employee.getSalary()
        getHireDay() -> Employee.getHireDay()
        raiseSalary(double) -> Employee.raiseSalary(double)
 实际上，以上列出的方法并不完整，之后会看到Employee类有一个超类Object，Employee类从这个超类中还继承了大量方法。
 Manager方法表稍微有些不同。其中有三个方法是继承而来的，一个方法是重新定义的，还有一个方法是新增加的。
    Manager:
        getName() -> Employee.getName()
        getSalary() -> Manager.getSalary()
        getHireDay() -> Employee.getHireDay()
        raiseSalary(double) -> Employee.raiseSalary(double)
        setBonus(double) -> Manager.setBonus()double
 在运行时，调用e.getSalary()的解析过程为：
 * 首先，虚拟机获取e的实际类型的方法表。这可能是Employee，Manager的方法表，也可能是Employee类的其他子类的方法表。
 * 接下来，虚拟机查找定义了getSalary()签名的类。此时，虚拟机已经知道应该调用哪个方法。
 * 最后，虚拟机调用这个方法。

 动态绑定有一个非常重要的特性：无需对现有的代码进行修改就可以对程序进行拓展。结社增加一个新类Executive，并且变量e有可能引用这个类的对象，我们不需要对包含调用e.getSalary()的代码重新进行编译。如果e恰好引用一个Executive类的对象，就会自动的调用Executive.getSalary()方法。
 * 在覆盖一个方法时，子类方法不能低于超类方法的可见性。特别是，如果超类方法是public，子类方法必须也要声明为public。

 7. 阻止继承：final类和方法
 有时候，我们可能希望阻止人们利用某个类定义子类。不允许拓展的类称为final类。如果在定义类的时候使用了final修饰符就表明这个类是final类。例如，假设希望阻止人们派生Executive类的子类，就可以在声明这个类的时候使用final修饰符。声明格式如下所示：
    public final class Executive extends Manager
    {
        . . .
    }
 类中的某个特定方法也可以被声明为final。如果这样做，子类就不能覆盖这个方法(final类终得所有方法自动成为final方法)。例如
    public class Employee
    {
        . . .
        public final String getName()
        {
            return name
        }
    . . .
    }
 * 字段也可以声明为final。对于final字段来说，构造对象之后就不允许改变他们的值了。不过，如果将一个类声明为final，只有其中的方法自动的称为final，而不包括字段。

 将方法或类声明为final的主要原因是：确保他们不会在子类中改变语义。例如，Calendar类中的getTime和setTime方法都声明为final表示Calendar类的设计者负责实现Date类与日历状态之间的切换，而不允许子类来添乱。同样的，String类也是final类，这意味着不允许任何人定义String的子类。换言之，如果有一个String引用，他引用的一定是一个String对象，而不可能是其他类的对象。

 8. 强制类型转换
 Java为强制类型转换提供了一种特殊的表示法。例如：
    double x = 3.405;
    int nx = (int) x;
 将表达式x的值转换成整数类型，舍弃了小数部分。
 要完成对象引用的强制类型转换，转换语法与数值表达式的强制类型转换类似。例如，
    Manager boss = (Manager) staff[0]
 进行强制类型转换的唯一原因是L要在暂时忽视对象的实际类型之后使用对象的全部功能。
 将一个值存入变量时，编译器将检查你是否承诺过多。如果将一个子类的引用赋给一个超类变量，编译器是允许的。但将一个超类的引用赋给一个子类变量时，就承诺过多了。必须进行强制类型转换，这样才能够通过运行时的检查。
 如果试图在继承链上进行向下的强制类型转换，并且谎报对象包含的内容，例如：
    Manager boss = (Manager) staff[1];   //Error
 运行程序时，java运行系统将注意到你的承诺不符，冰蟾是一个ClassCastException异常。如果没有捕获这个异常，程序就会终止。
 应当养成一个良好的设计习惯L在进行强制类型转换之前，先查看是否能够成功地转换。为此只需要使用instanceof操作符就可以实现。例如：
    if (staff[1] instanceof Manager)
    {
        boss = (Manager) staff[1];
        . . .
    }
 最后，如果这个类型转换不可能成功，编译器就不会让你完成这个转换。例如：
    String c = (String) staff[1];
 将会产生编译错误，这是因为String不是Employee的子类。
 综上：
 * 只能在继承层次内进行强制类型转换
 * 在将超类强制类型转换成子类之前，应该使用instanceof进行检查

 如果x为null，
    x instanceof C      //不会产生异常，只是会返回false。之所以这样处理是因为null没有引用任何对象，当然也不会引用C类型的对象
 一般情况下，最好尽量少用强制类型转换和instanceof运算符。如果需要用到之前，先检查超类的设计是否合理。

 9. 抽象类
 如果自下而上在类的继承层次结构中上移，位于上层的类更具有一般性，可能更加抽象。
 例如，考虑拓展Employee类层次结构。员工是一个人，学生也是一个人。下面拓展类层次架构加入Person类和Student类。
 提供这样一个高层次的抽象原因是每个人都有一些属性，如姓名，因此通过引入一个公共的超类，沃尔玛你可以把getName方法放在继承层次结构的更高一层。
 现在再加入一个getDescription方法，他可以返回对一个人的简短描述。如：
    an employee with a salary of $50000.00
    a student majoring in computer science
 在Employee类和student类中实现这个方法很容易，但是在Person类中，除了姓名之外，Person类对这个人一无所知。当然，可以让Person.getDescription()返回一个空字符串。但是还有一个更好的方法，就是使用abstract关键字，这样就完全不需要实现这个方法了。
    public abstract String getDescription();    //不需要实现
 为了提高程序的清晰度，包含一个或多个抽象方法的类本身必须被声明为抽象的。
    public abstract class Person
    {
        . . .
        public abstract String getDescription();
    }
 除了抽象方法之外，抽象类还可以包含字段和具体方法。例如Person类还保存着一个人的性命，另外有一个返回姓名的具体方法。
    public abstract class Person
    {
        private String name;

        public person（String name）
        {
            this.name = name;
        }

        public abstract String getDescription();

        public String getName()
        {
            return name;
        }
    }
 抽象方法充当着占位方法的角色，他们在子类中具体实现。拓展抽象类可以有两种选择。一种是在子类中保留抽象类中的部分或所有抽象方法仍未定义，这样就必须将子类也标记为抽象类；另一种做法是定义全部方法，这样一来，子类就不是抽象的了。
 例如通过拓展抽象Person类，并实现getDescription方法来定义Student类。由于在Student类中不在含有抽象方法，有意不需要将这个类声明为抽象类。
 即使不含抽象方法，也可以将类声明为抽象类。
 抽象类不能实例化。也就是说，如果将一个类声明为abstract，就不能创建这个类的对象。例如，表达式
    new Person("abc")
 是错误的，但是可以创建一个具体子类的对象。
 需要注意，可以定义一个抽象类的对象变量，但是这样一个变量只能引用非抽象子类的对象。例如，
    Person p = new Student("abc", "Economics");
 这里的p是一个抽象类型Person的变量，爱他引用了一个非抽象子类Students的实例。
 下面定义一个拓展抽象类Person的具体子类Student：
    public class Student extends Person
    {
        private String major;

        public Student(String name, String major)
        {
            super(name);
            this.major = major;
        }
        public String getDescription()
        {
            return "a student major in " + major;
        }
    }
 Student类定义了getDescription方法。因此，在Student类中的全部方法都是具体的，这个类不再是抽象类。
 *
 *
 *
 */





public class VariousClass {
}
