package IO;

import org.junit.Test;

import java.io.*;

/**
 * @Auther: Carl
 * @Date: 2021/02/15/18:45
 * @Description:
 *
 *  处理流之一：缓冲流的使用
 *  1. 缓冲流
 *  BufferedInputStream
 *  BufferedOutputStream
 *  BufferedReader
 *  BufferedWriter
 *
 *  2. 缓冲流的作用：提高流的读取、写入的速度
 *      提高读写速度的原因：
 *
 *  3. 处理流，就是套接已有流的基础上
 *
 */
public class BufferTest {

    /*
    实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1. 造文件
            File srcFile = new File("头像.jpg");
            File destFile = new File("新头像.jpg");

            //2. 造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3. 读取、写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        //4. 资源关闭
        //要求：先关闭外层流，再关闭内层流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，可以省略。
//        fos.close();
//        fis.close();
        }
    }

    public void copyFileBuffered(String srcPath, String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1. 造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //2. 造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3. 读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);

//                bos.flush();  //刷新缓冲区
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 资源关闭
            //要求：先关闭外层流，再关闭内层流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，可以省略。
//        fos.close();
//        fis.close();
        }
    }

    @Test
    public void testCopyFileBuffered(){
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\Carl\\Videos\\最长的电影.mp4";
        String destPath = "C:\\Users\\Carl\\Videos\\复制-最长的电影.mp4";
        copyFileBuffered(srcPath, destPath);

        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("复制消耗时间：" + time);   //243
    }

    /*
    使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void testBufferedReaderWriter() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //以匿名方式创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp-copy.txt")));

            //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = br.read(cbuf)) != -1) {
//                bw.write(cbuf, 0, len);
//    //            bw.flush();
//            }

            //方式二：使用String
            String data;
            while ((data = br.readLine()) != null) {
                //方法一
//                bw.write(data + "\n");     //data中不包含换行符
                //方法二
                bw.write(data);
                bw.newLine();
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
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
