import java.util.Arrays;
import java.util.Scanner;

/*************************
 6. 数组排序
 想要对数值型数组进行排序，可以使用Array中的sort方法：
    int[] a = new int[10000];
    . . .
    Arrays.sort(a)
    这个方法使用了优化的快速排序(QuickSort)算法。快速排序算法对大多数数据集合而言效率都比较高

 7. 多维数组
 for each循环语句不能自动处理二维数组的每一个元素。他会循环处理行，而这些行本身就是一维数组。
 想要访问二维数组a的所有元素，需要使用两个嵌套的循环，如图所示：
    for (double[] row : a)
        for[ (double value : row)
            do something with value
 * 想要快速打印一个二维数组的数据元素列表，可以调用
    System.out.println(Arrays.deepToString(a));

 */

//程序功能：产生一个抽采游戏中的随机数字组合。
public class Array3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("输入共有多少数字");
        int n = in.nextInt();           //控制台输入

        System.out.println("输入抽取几个数字");
        int k = in.nextInt();           //控制台输入

        int[] numbers = new int[n];         //初始化全部数字数组numbers
        for (int i = 0; i < numbers.length; i++)        //循环全部的数字
            numbers[i] = i + 1;                         //将循环的数字顺次存入数组中numbers[0] = 1,numbers[1] = 2, ...

            int[] result = new int[k];          //初始化抽取数组result
        for (int i = 0; i < result.length; i++)
        {
            int r = (int)(Math.random() * n);   //Math.random方法返回一个0-1之间的（包含0，不包含1）的随机浮点数
                                                //用n乘以这个浮点数，得到从0-n-1之间的一个随机数,例如50个数，r的范围即0-49,
                                                //正好对应数组的下标值。

            result[i] = numbers[r];             //将numbers数组中随机抽取到的下标为r的数的值赋予result数组中地i个元素。

            numbers[r] = numbers[n-1];
            n--;
            /*将数组中最后一个元素numbers[n-1]=n的下标值赋给随机数乘法得到的r，最终使numbers[r]的值变为之前数组中最后一个元素的值，
            原本的numbers[r]的值抹去，同时将n-1，实现了numbers[r]的原值不再取到并且替换了n-1情况下无法取到的numbers[n-1]的值*/
        }

        Arrays.sort(result);
        for (int r : result)
    /*
     * 由于Arrays.sort是静态方法，需要搭配for each循环result数组中每一个元素
     */
        System.out.println(result);








    }
}
