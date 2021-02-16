package array;

public class ArrayTest {

    public static void main(String[] args) {

        //1. 一维数组的声明和初始化
        int[] a;    //声明
        a = new int[]{1, 2, 3, };   //静态初始化

        String[] b = new String[3]; //动态初始化
        //数组一旦初始化完成，其长度就确定了

        //2. 如何调用数组指定位置的元素：通过角标的方式调用
        b[0] = "HELLO ";
        b[1] = "WORLD ";    //charAt(0) -> W    charAt(1) -> O
        b[2] = "! ";

        //3. 如何获取数组的长度
        //属性：length
        System.out.println(b.length);   //3

        //如何遍历数组元素
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }
    }
}
