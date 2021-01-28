package class_and_method.array;

public class ArrayTest1 {

    public static void main(String[] args) {

        //数组元素的默认初始化值
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        /*整型初始化值：0
        * 浮点型初始化值：0.0
        * char型初始化值：ASCII码 -> 0 而非'0'
        * String型初始化值：null
        * 布尔型初始化值：false */
    }
}
