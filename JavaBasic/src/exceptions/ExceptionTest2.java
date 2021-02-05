package exceptions;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Auther: Carl
 * @Date: 2021/02/03/20:36
 * @Description:
 *              try-catch-finally中finally的使用
 *              1. finally是可选的
 *              2. finally声明的是一定会被执行的代码。即使catch中又出现异常了，或者try中有return语句，catch中有return语句等情况。
 *              3. 像数据库连接、输入输出流、网络编程Socket等资源，JVM是不能自动回收的，需要自己手动进行资源释放。此时的资源释放，就
 *                  需要声明在finally中。
 *
 *
 */
public class ExceptionTest2 {

    @Test
    public void test2(){
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);
            int data = fis.read();
            while(data!=-1){
                System.out.println((char) data);
                data = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)    //不需要加括号。若fis为null则不需要释放空间。
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1(){
        try {
            int a = 10, b = 0;
            System.out.println(a / b);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("这是一个测试");
        }
    }
}
