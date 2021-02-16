import java.math.BigInteger;
import java.util.Scanner;

/***********************
 如果整数和浮点数精度不能够满足需求，java.math包中很有用的两个类：BigInteger和BigDecimal。
 这两个类可以处理任意长度数字序列的数值。
    BigInteger类实现任意精度的整数运算
    BigDecimal实现任意精度的浮点数运算

 使用静态的valueOf方法可以将普通数值转换为大数
        BigInteger a = BigInteger.valueOf(100);
 *  不能用熟悉的算术运算符，如+和*处理大数，而需要使用大数类终得add和multiply方法。
        BigInteger c = a.add(b);    //c=a + b
        BigInteger d = c.multiply(b.add(BigInteger.valueOf(2)));    //d = c * (b + 2)
 */

//程序要求:使用大数处理在k个数字中抽取n个数字中奖的概率是多少
public class BigIntegerTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("一共有多少个数字？");
        int k = in.nextInt();

        System.out.println("打算抽取多少数字？");
        int n = in.nextInt();

        BigInteger possibility = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++)
        possibility = possibility.multiply(BigInteger.valueOf(k - i + 1)).divide(BigInteger.valueOf(i));

        System.out.println("中奖的概率是1/" + possibility);
    }
}
