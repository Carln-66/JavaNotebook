package class_and_method.object_construction;

/**
在本程序中展示了本节对象构造中讨论的很多特性
         * 重载构造器
         * 用this(...)调用另一个构造器
         * 无参数构造器
         * 对象初始化块
         * 静态初始化块
         * 实例字段初始化
 */
public class ConstructorTest {
    public static void main(String[] args) {

        var staff = new ConstructorEmployee[3];

        //在staff数组中填入3个Employee对象
        staff[0] = new ConstructorEmployee("Harry", 40000);
        staff[1] = new ConstructorEmployee(60000);
        staff[2] = new ConstructorEmployee();

        for (ConstructorEmployee e : staff)
            System.out.println("name = " + e.getName() + ", id = " + e.getId() + ", salary = " +
                    e.getSalary());
    }
}
