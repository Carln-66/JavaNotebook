import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Auther: Carl
 * @Date: 2021/02/16/21:31
 * @Description:
 *  RandomAccessFile的使用
 *  1. RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 *  2. RandomAccessFile即可作为一个输入流，又可以作为一个输出流
 *  3. 如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。
 *     如果写出到的文件存在，则会对原有文件内容进行覆盖(默认情况下从头覆盖)。
 *  4. 可以通过相关的操作，实现RandomAccessFile”插入“数据的效果
 *
 *
 */
public class RandomAccessFileTest {

    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("头像.jpg"), "r");
            raf2 = new RandomAccessFile(new File("新头像.jpg"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("Test.txt", "rw");

        raf1.seek(8);   //  把指针调到角标为8的位置
        raf1.write("(I'm here!))".getBytes());  //
        raf1.close();
    }

    /*
        使用RandomAccessFile实现插入效果
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("Test.txt", "rw");

        raf1.seek(8);   //  把指针调到角标为8的位置
        //保存指针后的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("Test.txt").length());
        byte[] buffer = new byte[5];
        int len;
        while ((len = raf1.read(buffer)) != -1) {
            builder.append(new String(buffer, 0, len));
        }
        //调回指针，写入字符串
        raf1.seek(8);
        raf1.write("(Hi! It's me!)".getBytes());
        //将StringBuilder中的数据写入到文件中
        raf1.write(builder.toString().getBytes());

        raf1.close();
    }
}
