package practice;

/**
 * @Auther: Carl
 * @Date: 2021/02/07/18:20
 * @Description:  * 1.模拟一个trim方法，去除字符串两端的空格。
 */
public class trimTest {

    public static void main(String[] args) {
        myTrimTest myTrimTest = new myTrimTest();
        String s = myTrimTest.myTrim("   11asd sakdaj diu qwd---   ");
        System.out.println(s);
    }

}

class myTrimTest{
    public String myTrim(String string){
        if (string != null) {
            int start = 0;
            int end = string.length() - 1;
            while (start < end && string.charAt(start) == ' '){
                start++;
            }
            while (start < end && string.charAt(end) == ' '){
                end--;
            }
            if (string.charAt(start) == ' '){
                return "";
            }
            return string.substring(start, end + 1);
        }
        return null;
    }
}
