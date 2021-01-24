package Inheritance;

/**************************************
 5. 多态
 有一个简单的规则可以用来判断是否应该将数据设计为继承关系，就是"is-a"规则。他指出子类的每一个对象也是超类的对象。例如，每个经理都是员工，因此，将Manager类设计成为Employee类的子类是有道理的，反之则不然。
 "is-a"规则的另一种表述是替换原则(substitution principle)。他指出程序中出现超类对象的任何地方都可以使用子类对象替换。
 例如，可以将子类的对象赋给超类变量
    Employee e;
    e = new Employee(. . .);    //Employee object expected
    e = new Manager(. . .);     //OK,Manager can be used as well
 *
 *
 *
 */





public class Polymorphism {
}
