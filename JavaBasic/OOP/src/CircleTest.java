/**
 * @Auther: Carl
 * @Date: 2021/02/02/12:11
 * @Description:
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(2.5);
        Circle c2 = new Circle(3.2);

        System.out.println("c1 id = " + c1.getId());
        System.out.println("c2 id = " + c2.getId());
        System.out.println(Circle.getTotal());
    }
}

class Circle{
    private double radius;
    private int id; //自动赋值

    public Circle(){
        id = init++;
        total++;
    }

    public Circle(double radius) {
        this();
//      id = init++;
//      total++;
        this.radius = radius;

    }

    private static int total;
    private static int init = 1001;     //static声明的属性被所有的对象共享

    public double findArea(){
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }
}
