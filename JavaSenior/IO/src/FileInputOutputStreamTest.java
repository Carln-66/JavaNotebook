import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Auther: Carl
 * @Date: 2021/02/15/17:39
 * @Description:
 *  测试FileInput和FileOutputStream的使用
 *
 *  结论：1. 对于文本文件(.txt, .java, .c, .cpp)，使用字符流处理
 *       2. 对于非文本文件(.jpg, .avi, .mp3, .mp4, .doc...)，使用字节流处理
 *
 */
public class FileInputOutputStreamTest {

    //使用字节流FileInputStream处理文本文件，可能出现乱码。
    @Test
    public void testFileInputStream1() {

        FileInputStream fis = null;

        try {
            //1. 创建File类的对象
            File file = new File("hello.txt");

            //2. 创造输入流
            fis = new FileInputStream(file);

            //3. 数据读入
            byte[] buffer = new byte[5];
            int len;    //记录每次读取的字节的个数
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //实现对图片的复制操作
    @Test
    public void testFileInputStream2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("图片.jpg");
            File destFile = new File("新图片.jpg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    //指定路径下文件的复制
    public void copyFile(String srcPath, String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Test
    public void CopyFile(){
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\Carl\\Videos\\最长的电影.mp4";
        String destPath = "C:\\Users\\Carl\\Videos\\复制-最长的电影.mp4";
        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("复制消耗时间：" + time);   //300
    }
}
