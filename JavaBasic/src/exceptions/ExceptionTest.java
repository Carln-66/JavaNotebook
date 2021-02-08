package exceptions;

import org.junit.Test;

import java.util.Date;
import java.util.Scanner;


/**
 * @Auther: Carl
 * @Date: 2021/02/03/19:17
 * @Description: 异常
 *              一、异常体系结构
 *              java.lang.Throwable
 *                  |-------java.lang.Error：一般不编写针对性的代码进行处理
 *                  |-------java.lang.Exception：可以进行异常的处理
 *                      |-------编译时异常(checked)
 *                          |-------IOException
 *                              |-------FileNotFoundException
 *                          |-------ClassNotFoundException
 *                      |-------运行时异常(unchecked)
 *                          |-------NullPointerException
 *                          |-------ArrayIndexOutOfBoundsException
 *                          |-------ClassCastException
 *                          |-------NumberFormatException
 *                          |-------InputMismatchException
 *                          |-------ArithmeticException
 *
 */
public class ExceptionTest {

    /**************************编译时异常******************************/
//    @Test
//    public void test7(){
//        File file = new File("hello.txt");
//        FileInputStream fis = new FileInputStream(file);
//        int data = fis.read();
//        while(data!=-1){
//            System.out.println((char) data);
//            data = fis.read();
//        }
//        fis.close();
//    }
    /***************************运行时异常*****************************/
    //ArithmeticException
    @Test
    public void test6(){
        int a = 10, b = 0;
        System.out.println(a / b);
    }

    //InputMismatchException
    @Test
    public void test5(){
        Scanner input = new Scanner(System.in);
        int Demo = input.nextInt();
        System.out.println(Demo);
    }

    //NumberFormatException
    @Test
    public void test4(){
        String string = "abc";
        int num = Integer.parseInt(string);
    }

    //ClassCastException
    @Test
    public void test3(){
        Object obj = new Date();
        String string = (String)obj;
    }

    //ArrayIndexOutOfBoundsException
    @Test
    public void test2(){
        int array[] = new int[10];
        System.out.println(array[10]);
    }

    //NullPointerException
    @Test
    public void test1(){
        int[] arr = null;
        System.out.println(arr[3]);

        String string = null;
        System.out.println(string.charAt(0));
    }

}
