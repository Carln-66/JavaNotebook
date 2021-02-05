package class_and_method.array;

import java.util.Arrays;

/***
 * java.util.Arrays： 操作数组的工具类
 */

public class ArraysTest {
    public static void main(String[] args) {

        //1. boolean equals(int[] a, int[] b):判断两数组是否相等
        int[] arr1 = new int[]{1, 2, 3, 4 };
        int[] arr2 = new int[]{6, 3, 2, 4 };
        boolean isequals = Arrays.equals(arr1, arr2);
        System.out.println(isequals);

        //2. String toString(int[] a)：输出数组信息
        System.out.println(Arrays.toString(arr1));


        //3. void fill(int[] a, int val)：将指定值填充到数组中
        Arrays.fill(arr1,10);
        System.out.println(Arrays.toString(arr1));

        //4. void sort(int[] a)：对数组进行排序
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        //5. int binarySearch(int[] a, int key)：二分查找
        int[] arr3 = new int[]{43, 32, 76, -98, 0, 64, 33, -21, 32, 99};
        int index = Arrays.binarySearch(arr3,99);
        System.out.println(index);

    }


}
