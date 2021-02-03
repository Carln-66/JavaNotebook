package exceptions;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Auther: Carl
 * @Date: 2021/02/03/21:16
 * @Description:
 *              异常的处理方式二：
 *              1. "throws + 异常类型“此方法在执行时，可能会抛出异常类型。一旦当方法体执行时，出现异常，仍会在异常代码处
 *                  生成一个异常类的对象，此对象满足throws后面的异常类型时，就会被抛出。异常代码后的代码将不再执行。
 *              2. 总结：try-catch-finally：真正的处理掉了异常
 *                      throws只是将异常抛给了方法的调用者，并没有将异常真正的处理掉。
 *              3. 开发中如何选择使用try-catch-finally  还是使用throws
 *                  3.1 如果父类中被重写的方法没有throws方式处理异常，则子类重写的方法也不能使用throws，意味着如果子类重
 *                      写的方法中有异常，必须使用try-catch-finally方式处理。
 *                  3.2 执行的方法A中，又先后调用了另外几个方法，这几个方法是递进关系执行的。建议这几个方法使用throws方
 *                      式进行处理。而执行的方法A可以考虑使用try-catch-finally方式进行处理。
 */
public class ExceptionTest3 {

    public static void main(String[] args) {
        try {
            method2();
        }catch (IOException e){
            e.printStackTrace();
        }
        method3();
    }

    public static void method3(){
        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method2() throws IOException{
        method1();
    }

    public static void method1() throws FileNotFoundException, IOException {
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);
        int data = fis.read();
        while (data != -1) {
            System.out.println((char) data);
            data = fis.read();
        }
        fis.close();
    }
}
