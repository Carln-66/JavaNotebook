package string_class.practice;

import org.junit.Test;

/**
 * @Auther: Carl
 * @Date: 2021/02/08/9:15
 * @Description:
 */
public class DebugNull {

    //具体看源码
    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);     //不报错

        System.out.println(sb.length());    //4
        System.out.println(sb);     //"null"
        StringBuffer sb1 = new StringBuffer(str);   //抛异常：空指针
        System.out.println(sb1);
    }
}
