package ClassAndMethod.EmployeeStaticTest;

class Employee {
    //将nextId设置为静态使不论id有多少，该字段只有一个，即便没有EmployeeStaticTest对象，该静态字段依然存在
    private static int nextId = 1;

    private final String name;
    private double salary;
    private int id;

    //类构造器
    public Employee(String n, double s)
    {
        name = n;
        salary = s;
        id = 0;
    }

    //字段访问器
    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public int getId()
    {
        return id;
    }

    public void setId()
    {
        id = nextId;        //将nextId值赋予当前id，并将该值+1
        nextId++;
    }

    public static int getNextId()
    {
        return nextId;      //将nextId最为静态字段返回
    }

    public static void main(String[] args) {
        var e = new Employee("Harry", 50000);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}
