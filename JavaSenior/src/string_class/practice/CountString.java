package string_class.practice;

import org.junit.Test;

/**
 * @Auther: Carl
 * @Date: 2021/02/07/20:45
 * @Description: * 3.获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ab”在 “cdabkkcadkabkebfkabkskab”中出现的次数
 */
public class CountString {

    public int test(String s1, String s2) {

        int count = 0;
        int index = s2.indexOf(s1);
        // while((index = mainStr.indexOf(subStr)) != -1){
        // count++;
        // mainStr = mainStr.substring(index + subStr.length());
        // }
        // 改进：
        while (index != -1) {
            count++;
            index = index + s1.length();
            index = s2.indexOf(s1, index);
        }
        return count;
    }


    @Test
    public void test1() {
        CountString s = new CountString();
        int i = s.test("ab", "cdabkkcadkabkebfkabkskab");
        System.out.println(i);
    }
}


