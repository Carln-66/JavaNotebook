package GenericTest.exer;

/**
 * @Auther: Carl
 * @Date: 2021/02/12/15:22
 * @Description: TreeSet 练习
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    //指明泛型时的写法
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }

    //未指明泛型时的写法
    //按照name排序
//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof Employee){
//            Employee employee = (Employee) o;
//            return this.name.compareTo(employee.name);
//        }else {
//            throw new RuntimeException("输入数据类型不匹配");
//        }
//    }
}
