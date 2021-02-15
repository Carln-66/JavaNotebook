package IO;

import org.junit.Test;

import java.io.*;

/**
 * @Auther: Carl
 * @Date: 2021/02/15/9:40
 * @Description:
 *
 *  一、流的分类
 *      1. 操作数据单位；字节流、字符流
 *      2. 数据流向：输入流、输出流
 *      3. 流的角色：节点流、处理流
 *
 *  二、流的体系结构
 *  抽象基类                节点流                                                 缓冲流(处理流的一种)
 *  InputStream         FileInputStream  (read(byte[] buffer))                BufferedInputStream  (read(byte[] buffer))
 *  OutStream           FileOutputStream  (write(byte[] buffer, 0, len))      BufferedOutputStream  (write(byte[] buffer, 0, len))
 *  Reader              FileReader  (read(char[] cbuf))                       BufferedReader  (read(char[] cbuf) / readLine())
 *  Writer              FileWriter  (write(char[] cbuf, 0, len))              BufferedWriter  (write(char[] cbuf, 0, len))
 *
 *
 *
 */
public class FileReaderWriter {

    public static void main(String[] args) {
        File file = new File("Hello.txt");      //main方法中：相较于当前工程
        System.out.println(file.getAbsolutePath());

        File file1 = new File("JavaSenior\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }

    /*
    将JavaSenior下的"hello.txt"文件内容读入程序中，并输出到控制台

    说明：
    1. read(): 放回读入的一个字符。如果达到文件末尾，返回-1
    2. 异常的处理：为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
    3. 读入文件一定要存在，否则会报FileNotFoundException.
     */
    @Test
    public void testFileReader() {
        //1. 实例化File类的对象，指明要操作的文件
        FileReader fr = null;
        try {
            File file = new File("hello.txt");  //单元测试方法中：相较于当前Module

            //2. 提供具体的流
            fr = new FileReader(file);

            //3. 数据的读入
            //read(): 放回读入的一个字符。如果达到文件末尾，返回-1
            //方式一
//        int read = fr.read();
//        while (read != -1) {
//            System.out.print((char) read);
//            read = fr.read();
//        }

            //方式二：语法上的修改
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 流的关闭操作
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //read()操作升级：使用read重载的方法
    @Test
    public void testFileReader1() {
        //1. File类的实例化
        FileReader fr = null;
        try {
            File file = new File("hello.txt");

            //2. FileReader流的实例化
            fr = new FileReader(file);

            //3. 读入的操作
            //read(char[] cbuf): 返回每次读入cbuf数组中的字符个数。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //方式一
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }
                //方式二：
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 资源的关闭
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    从内存中写出数据到硬盘的文件里
    说明：
    1. 输出操作，对应File可以不存在，并不会抛出异常
    2. File对应的硬盘文件如果不存在，在输出的过程中，会自动创建此文件；如果存在：
        如果使用的构造器是 FileWriter(file, false) / FileWriter(file)：对原有文件的覆盖
        如果使用的构造器是 FileWriter(file, true)：不会对原有文件的覆盖，而是在原有文件基础上追加内容
     */
    @Test
    public void testFileWriter() throws IOException {

        //1. 提供File类的对象，指明写出到的文件
        File file = new File("hi.txt");

        //2. 提供FileWriter的对象，用于数据的写出
        FileWriter fw = new FileWriter(file);

        //3. 写出的操作
        fw.write("你好，世界！\n");
        fw.write("你好，地球！");

        //4. 流的关闭操作
        fw.close();
    }

    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            //1. 创建File类的对象，指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("New Hello.txt");
            //不能使用字符流来处理图片等字节数据

            //2. 创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3. 数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;    //用来记录每次读入到cbuf数组中字符的个数
            while ((len = fr.read(cbuf)) != -1) {
                //每次写出len个字符，写入cbuf个
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭流资源
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
