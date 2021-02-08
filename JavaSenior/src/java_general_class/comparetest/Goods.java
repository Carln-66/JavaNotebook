package java_general_class.comparetest;

/**
 * @Auther: Carl
 * @Date: 2021/02/08/16:45
 * @Description: 商品类
 */
public class Goods implements Comparable{
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明商品比较大小的方式:价格从高到低排序，如果两个价格相同，则按名声顺序排列
    @Override
    public int compareTo (Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            }else {
//                return 0;
                return this.name.compareTo(goods.name);
            }
        }
        throw new RuntimeException("传入数据类型不一致" );
    }

}
