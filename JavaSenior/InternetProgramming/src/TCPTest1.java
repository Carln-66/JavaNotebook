import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: Carl
 * @Date: 2021/02/17/23:38
 * @Description:
 *  实现TCP的网络编程
 *  例1：客户端发送信息给服务端，服务端将数据显示在控制台上
 *
 *
 */
public class TCPTest1 {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {

            //1. 创建Socket对象，指明服务器端IP和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 55566);
            //2. 获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3. 写出数据
            os.write("客户端测试".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //服务端
    @Test
    public void server(){

        ServerSocket serverSocket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        Socket socket = null;
        try {
            //1. 创建Server的Socket，指明自己的端口号
            serverSocket = new ServerSocket(55566);

            //2. 调用accept()方法接受来自于客户端的socket
            socket = serverSocket.accept();

            //3. 获取输入流
            is = socket.getInputStream();

            //由于可能出现乱码，因而不推荐这种写法
//        char[] buffer= new char[1024];
//        int len;
//        while ((len = is.read(buffer)) != -1) {
//            String str = new String(buffer, 0, len);
//            System.out.println(str);
//        }

            //4. 读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            //输出客户端输入的内容
            System.out.println(baos.toString());
            //获取客户端IP地址
            System.out.println(socket.getInetAddress());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
