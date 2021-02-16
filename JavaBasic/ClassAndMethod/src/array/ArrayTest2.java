package array;

public class ArrayTest2 {
    public static void main(String[] args) {

        //1. 二维数组的声明和初始化
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6},{7, 8, 9}, {10, 11}};  //静态初始化

        String[][] b = new String[3][3];    //动态初始化1
        String[][] c = new String[5][];    //动态初始化2

        //2. 如何调用二维数组指定位置的元素
        System.out.println(a[1][2]);        //6
        System.out.println(b[2][1]);        //null
        c[1] = new String[4];               //二维数组c在栈中地址首先指向堆中对应的元素，将未赋值的第二个数组元素声明为String[4]的数组

        //3. 获取二维数组的长度
        System.out.println(b.length);       //3
        System.out.println(a[3].length);    //2

        //4. 如何遍历二维数组
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j< a[i].length; j++)
            {
                System.out.print(a[i][j] + " ");
            }
        }

    }
}
