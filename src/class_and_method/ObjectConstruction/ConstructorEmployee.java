package class_and_method.ObjectConstruction;

import java.util.Random;

class ConstructorEmployee {
    private static int nextId;

    private final int id;
    private String name = "";       //显式字段初始化
    private double salary;

    //静态初始化块
    static
    {
        var generator = new Random();
        nextId = generator.nextInt(10000);
    }

    //对象初始化块
    {
        id = nextId;
        nextId++;
    }

    //三个重载构造器
    public ConstructorEmployee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    //调用上一个构造器
    public ConstructorEmployee(double salary)
    {
        this("Employee #" + nextId, salary);
    }

    //无参数构造器
    public ConstructorEmployee()        //如果没有此无参数的构造器，则staff[3]不提供参数则会报错
    {
        //name初始化为""
        //salary初始化为0
        //id在对象初始化块中被初始化
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
