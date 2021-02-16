package IO.object_stream;

import org.junit.Test;

import java.io.*;

/**
 * @Auther: Carl
 * @Date: 2021/02/16/20:31
 * @Description:
 *
 *  对象流的使用
 *  1. ObjectInputStream 和 ObjectOutputStream
 *  2. 作用：用于储存和读取基本数据类型数据或对象的处理流。他的强大之处就是可以把Java中的对象
 *  3. 一个java对象要想是可序列化的，需要满足相应的要求。见Person类
 *  4. 序列化机制：对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久的保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。当其他程序获取了这种二进制流，就可以恢复成原来的Java对象。
 *
 *  补充：ObjectOutputStream 和 ObjectInputStream不能序列化static和transient(可以将不想序列化的成员变量用transient修饰)修饰的成员变量
 *
 *
 *
 */
public class ObjectInputOutputStreamTest {

    /*
        序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
        使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            //造流、对象
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));
            //写入
            oos.writeObject(new String("这是一个测试"));
            oos.flush();    //刷新

            oos.writeObject(new Person("张三", 18));
            oos.flush();

            oos.writeObject(new Person("李四", 250, new Account(5000.0)));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        //关闭流
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        反序列化：将磁盘文件中的对象还原为内存中的一个java对象
        使用ObjectInputStream
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));
            Object object = ois.readObject();
            String str = (String) object;

            Person p = (Person) ois.readObject();
            Person p1 = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
            System.out.println(p1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
