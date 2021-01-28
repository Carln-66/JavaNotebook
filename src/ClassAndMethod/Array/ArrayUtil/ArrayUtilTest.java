package ClassAndMethod.Array.ArrayUtil;

public class ArrayUtilTest {
    public static void main(String[] args) {
        ArrayUtil util = new ArrayUtil();
        int[] arr = new int[]{12, 45, 78, 64, -65, 13, 10, 37};
        int max = util.getMax(arr);
        System.out.println("最大值为：" + max);

        int min = util.getMin(arr);
        System.out.println("最小值为：" + min);

        util.sort(arr);
        util.print(arr);
    }
}