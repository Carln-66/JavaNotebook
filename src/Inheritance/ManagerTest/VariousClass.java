package Inheritance.ManagerTest;

/****************************
 类，超类，子类
 在前一章中，讨论过Employee类。假设在某个公司中工作，这个公司的经理待遇和普通员工存在着一些差异。不过它们之间也有共通点。例如，他们都领取薪水。只是普通员工在完成本职工作后仅领取薪水，而经理在完成了预期业绩后还能得到奖金，这种情形就需要使用继承。
 因为需要为经理定义一个新类Manager，并增加一些新功能。但可以重用Employee类中已经编写的部分代码，并保留原来Employee类中的所有字段。从理论上讲，在Manager与Employee之间存在着明显的"is-a"(是)关系，每个经历都是一个员工："is-a"关系是继承的一个明显特征。

 1. 定义子类
 可以如下继承Employee类来定义Manager类，这里使用关键字extends表示继承。
    public class Manager extends Employee
    {
        add methods and fields
    }
 关键字extends表明正在构造的新类派生于一个已经存在的类。这个已存在的类称为超类(superclass)，基类(base class)或父类(parent class)；新类被称为子类(subclass)，派生类(derived class)或孩子类(child class)。
 在Manager类中，增加了一个用于储存奖金信息的字段，以及一个用于设置这个字段的新方法：
    public class Manager extends Employee
    {
        private double bonus;
        . . .
         public void set Bonus(double bonus)
        {
            this.bonus = bonus;
        }
    }
 这里定义的方法和字段没有什么特别之处。如果有一个manager对象，就可以使用setBonus方法。
    Manager boss = . . .;
    boss.setBonus(5000);
 当然，由于setBonus方法不是在Employee类中定义的，所以属于Employee类的对象不能使用它。
 然而，尽管在Manager类中没有显式的定义getName和getHireDay等方法，但是可以对Manager对象使用这些方法，这是因为Manager类自动的继承了超类Employee中的这些方法。
 通过拓展超类定义子类的时候，只需要指出子类和超类的不同之处。因此在设计类的时候，应该将最一般的方法写在超类中，而将更特殊的方法放在子类中，这种将通用功能抽取到超类的做法在面向对象程序设计中十分普遍。

 2. 覆盖方法
 超类中的有些方法对子类Manager并不一定是用。具体来说Manager类终得getSalary方法应该返回薪水和奖金的总和。为此，需要提供一个新的方法来覆盖（override）超类终得这个方法：
    public class Manager extends Employee
    {
        . . .
        public double getSalary()
        {
            . . .
        }
        . . .
    }
 实现这个方法不能够直接返回salary和bonus字段的总和
    public double getSalary()
    {
        return salary + bonus;      //无法工作
    }
 只有Employee方法能够直接访问Employee类的私有字段。这意味着，manager类的getSalary方法不能直接访问salary字段。如果Manager类的方法想要访问那些私有字段，就要像所有方法一样使用公共接口，在这里就是要使用Employee类中的公共方法getSalary。
 通过调用getSalary方法而不是直接访问salary字段：
    public double getSalary()
    {
        double baseSalary = getSalary();    //仍然无法工作
        return baseSalary +bonus;
    }
 以上代码仍有问题。问题出现在调用getSalary的语句上，他只是在调用自身，这是因为Manager类也有一个getSalary方法(就是正在实现的这个方法)，所以这条语句将会导致无限次的调用自己，直到程序崩溃。
 需要指出的是，我们希望调用Employee终得getSalary方法，而不是当前类的这个方法。为此，可以使用特殊的关键字super解决这个问题。
    super.getSalary()
 这个语句调用的是Employee类中的getSalary方法。下面是Manager类中getSalary方法的正确版本：
    public double getSalary()
    {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
 this与super不能看作类似的概念。不能将值super赋给另一个对象变量，她只是一个只是编译器调用超类方法的特殊关键字。
 子类中可以增加字段，增加方法或覆盖超类的方法，不过继承绝对不会删除任何字段或方法。

 3. 子类构造器
    public Manager(String name, double salary, int year, int month, int day)
    {
        super(name, salary, year, month, day);
        bonus = 0;
    }
 这里关键字super具有不同的含义。
    super(name, salary, year, month, day)
 是"调用超类Employee中带有n,s,year,month和day参数的构造器"的简写形式。
 由于Manager类的构造器不能访问Employee类的私有字段，所以必须通过一个构造器来初始化这些私有字段。可以利用特殊的super语法调用这个构造器。使用super调用构造器的语句必须是子类构造器的第一条语句。
 如果子类的构造器没有显式的调用超类的构造器，将自动的调用超类的无参数构造器。如果超类没有无参数构造器，并且在子类构造器中没有显式的调用超超类的其他构造器，Java会报错。
 在重新定义Manager对象的getSalary方法之后，奖金就会自动的添加到经理的薪水中。
 下面的例子能够说明这个类的使用。首先要创建一个新经理，并设置他的奖金。
    Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
    boss.setBonus(5000);
 下面定义一个包含三个员工的数组
    var staff = new Employee[3];
 在数组中填入经理和员工：
    staff[0] = boss;
    staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
    staff[2] = new Employee("Tong Tester", 40000, 1990, 3, 15);
 输出每个人的薪水
    for(Employee e : staff)
    System.out.println(e.getName() + " " + e.getSalary());
 运行结果：
    Carl Cracker 85000.0
    Harry Hacker 50000.0
    Tony Tester 40000.0
 这里的staff[1]和staff[2]金属除了进本薪水，原因是他们是Employee对象，而staff[0]是一个Manager对象，他的getSalary方法是奖金与薪水的和。

 需要注意，以下调用
        e.getSalary（）
 能够选出应该实行正确的getSalary方法。注意，尽管这里e声明为Employee类型，但实际上e既可以引用Employee类型的对象，也可以引用Manager类型的对象。
 当e引用Manager对象时，e.getSalary()调用的是Manager类终得getSalary方法。JVM知道e实际引用的对象类型，因此能够正确的调用相应的方法。
 一个变量对象变量(例如变量e)可以只是多种实际类型的现象称为多态(polymorphism)。在运行时能够自动的选择适当的方法，称为动态绑定(dynamic binding)。

 */



public class VariousClass {
}
