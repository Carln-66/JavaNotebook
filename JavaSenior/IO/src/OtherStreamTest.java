import org.junit.Test;

import java.io.*;

/**
 * @Auther: Carl
 * @Date: 2021/02/16/12:46
 * @Description:
 *
 *  其他流的使用
 *  1. 标准的输入、输出流
 *  2. 打印流
 *  3. 数据流
 *
 *
 */
public class OtherStreamTest {

    /*
        标准的输入、输出流
        System.in: 标准的输入流，默认从键盘输入
        System.out: 标准的输出流，默认从控制台输出

        可以通过System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出的流
     */
    //练习：从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。
    //方法一：使用Scanner实现，调用next()返回一个字符串
    //方法二：使用System.in实现     System.in ---> 转换流 ---> BufferedReader的readLine()
    @Test
    public void test1(){
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true) {
                System.out.print("输入字符串(输入e或exit退出): ");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        打印流：PrintStream和PrintWriter
        提供了一系列重载的print()和println()
     */

    @Test
    public void test2(){
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\IO\\text.txt"));
// 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }

            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /*
        数据流
        DataInputStream和DataOutputStream
        作用：用于读取或写出基本数据类型的变量或字符串

        将内存中的字符串、基本数据类型的变量写出到文件中。
        注意：处理异常仍然应该使用try-catch-finally
     */

    @Test
    public void test3(){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data.txt"));
            dos.writeUTF("张三");
            dos.flush();    //刷新操作，将内存中的数据写入文件
            dos.writeInt(21);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        将文件中储存的基本数据类型变量和字符串读取到内存中，保存在变量中。

        注意：读取数据的顺序要与当初写入文件时保存的数据顺序一致，否则报错
     */
    @Test
    public void test4(){
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("data.txt"));
            String s = dis.readUTF();
            int i = dis.readInt();
            boolean b = dis.readBoolean();
            System.out.println("name = " + s);
            System.out.println("age = " + i);
            System.out.println("isMale = " + b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
