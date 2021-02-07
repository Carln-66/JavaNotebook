package string_class.practice;

/**
 * @Auther: Carl
 * @Date: 2021/02/07/19:41
 * @Description: 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
 */
public class ReverseStringTest {

    public String myReverse(String s, int start, int end){

        //方法一
//        char[] charArray = s.toCharArray();
//        String s1 = "";
//        if (s != null){
//            for (int i = start, j = end; i < j; i++, j--){
//                char temp = charArray[i];
//                charArray[i] = charArray[j];
//                charArray[j] = temp;
//            }
//        }
//        return new String(charArray);
//    }

        //方法二
//        public String reverse3(String s, int start, int end) {// ArrayList list = new ArrayList(80);
            // 1.
            StringBuffer s1 = new StringBuffer(s.length());
            // 2.
            s1.append(s.substring(0, start));// ab
            // 3.
            for (int i = end; i >= start; i--) {
                s1.append(s.charAt(i));
            }

            // 4.
            s1.append(s.substring(end + 1));

            // 5.
            return s1.toString();

        }

    public static void main(String[] args) {
        ReverseStringTest stringTest = new ReverseStringTest();
        String s = stringTest.myReverse("123456789", 0, 5);
        System.out.println(s);
    }
}

