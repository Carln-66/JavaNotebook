package Inheritance.AbtractClass.PersonTest;

public class PersonTest {

    public static void main(String[] args) {
        var people = new Person[2];
        var employee = new Employee[2];

        people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "computer science");

        employee[0] = new Employee("张三",50000, 1990, 4, 2);
        employee[1] = new Employee("李四", 45000, 1980, 3, 9);
        for (Person p : people)
            System.out.println(p.getName() + ", " + p.getDescription());

        for (Employee e : employee)
            System.out.println(e.getName() + ", " + e.getSalary() + ", " + e.getHireDay()+ ", " + e.getDescription());
    }
}
