package java_general_class;

import org.junit.Test;

/**
 * @Auther: Carl
 * @Date: 2021/02/08/21:50
 * @Description:
 *      System
 *      Math：java.lang.Math提供了一系列静态方法用于科学计算。其方法的参数和返回
 * 值类型一般为double型。
 * abs 绝对值
 * acos,asin,atan,cos,sin,tan 三角函数
 * sqrt 平方根
 * pow(double a,double b) a的b次幂
 * log 自然对数
 * exp e为底指数
 * max(double a,double b)
 * min(double a,double b)
 * random() 返回0.0到1.0的随机数
 * long round(double a) double型数据a转换为long型（四舍五入）
 * toDegrees(double angrad) 弧度—>角度
 * toRadians(double angdeg) 角度—>弧度
 *      BigInteger和BidDecimal
 */
public class OtherClassTest {

    @Test
    public void test1(){
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);
        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);
        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);
        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);
        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);
        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);
        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);
    }

    @Test
    public void test2(){

    }
}
