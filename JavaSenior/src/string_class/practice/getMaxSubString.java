package string_class.practice;

import org.junit.Test;

/**
 * @Auther: Carl
 * @Date: 2021/02/07/21:22
 * @Description: 获取两个字符串中最大相同子串。比如：
 *    str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
 *    提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 */
public class getMaxSubString {

    //未完成
    public String test(String str1, String str2){
        if (str1 != null &&  str2 != null){
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            String maxStr = (str1.length() > str2.length() ? str1 : str2);
            int length = minStr.length();

            //下面循环体表示xy两个指针所包围的区域在每一次i+1时都从字符串的最左端向右移动，
            // 直至最右端指针y超出字符串长度length，以此类推，取出所有结果
            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++, y++){
                    String substring = minStr.substring(x, y);
                    if (maxStr.contains(substring)){
                        return substring;
                    }
                }
            }

        }
        return null;
    }

    @Test
    public void teat1(){
        getMaxSubString string = new getMaxSubString();
        String s = string.test("abcwerthelloyuiodef", "cvhellobnm");
        System.out.println(s);

    }
}
