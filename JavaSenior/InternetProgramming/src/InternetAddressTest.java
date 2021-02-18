import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Auther: Carl
 * @Date: 2021/02/17/22:13
 * @Description:
 *
 *  一、网络编程中有两个主要的问题
 *  1. 如何准确地定位网络上一台或多台主机：定位主机上的特定应用
 *  2. 找到主机后如何可靠高效的进行数据传输
 *
 *  二、网络编程中的两个要素
 *  1. 对应问题一：IP和端口号
 *  2. 对应问题二：提供网络通信协议：TCPTest3/IP参考模型(应用层、传输层、网络层、物理+数据链路层)
 *
 *  三、通信要素一：IP和端口号
 *  1. IP：唯一的表示Internet上的计算机(通讯实体)
 *  2. 在java中使用InetAddress类代表IP
 *  3. IP分类：IPv4和IPv6；万维网 和 局域网。
 *  4. 域名： 例如：www.baidu.com
 *  5. 本地回路地址：127.0.0.1 对应着：localhost
 *  6. 如何实例化InetAddress：两个方法：getByName(String host)、getLocalHost()
 *      两个常用方法：hetHostName()/getHostAddress()
 *
 *  7. 端口号：正在计算机上运行的进程。
 *      要求：不同的进程有不同的端口号
 *      范围：被规定为一个16位的整数0-65535
 *  8. 公认端口：0-1023.呗预先定义的服务通信占用(如：HTTP占用端口80，FTP占用端口21，TeInet占用端口23)
 *      注册端口：1024-49151.分配给用户进程或应用程序。(如Tomcat占用端口8080，MySQL占用端口3306，Oracle占用端口1521等)。
 *      动态/私有端口：49152-65535
 *
 *      端口号与IP地址组合得出一个网络套接字：Socket
 *
 *
 *
 *
 *
 */
public class InternetAddressTest {

    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.1.1");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("localhost");
            System.out.println(inet3);

            //获取本机IP
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);

            //getHostName()
            System.out.println(inet2.getHostName());

            //getHostAddress()
            System.out.println(inet2.getHostAddress());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
