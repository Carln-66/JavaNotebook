package practice;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Carl
 * @Date: 2021/02/07/21:32
 * @Description: 对字符串中字符进行自然顺序排序。"abcwerthelloyuiodef"
 * 提示：
 * 1）字符串变成字符数组。
 * 2）对数组排序，选择，冒泡，Arrays.sort(str.toCharArray());
 * 3）将排序后的数组变成字符串。
 */
public class SortStringTest {

    public String test(String str){
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String s = new String(charArray);
        return s;
    }

    @Test
    public void test(){
        SortStringTest sortStringTest = new SortStringTest();
        String s = sortStringTest.test("abcwerthelloyuiodef");
        System.out.println(s);
    }
}
