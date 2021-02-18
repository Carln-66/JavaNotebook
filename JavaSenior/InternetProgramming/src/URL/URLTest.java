package URL;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Auther: Carl
 * @Date: 2021/02/19/0:43
 * @Description:
 *  URL网络编程
 *  1. URL: 统一资源定位符，对应着互联网的某一资源地址
 *  2. URL格式: http://localhost:8080/examples/test.txt
 *              协议      主机名 端口号 资源地址    参数列表
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/examples/test.txt?username=Tom");

            //获取该URL的协议名
            //public String getProtocol()
            System.out.println(url.getProtocol());

            //获取该URL的主机名
            //public String getHost()
            System.out.println(url.getHost());

            //获取该URL的端口号
            //public String getPort()
            System.out.println(url.getPort());

            //获取该URL的文件路径
            //public String getPath()
            System.out.println(url.getPath());

            //获取该URL的文件名
            //public String getFile()
            System.out.println(url.getFile());

            //获取该URL的查询名
            //public String getQuery()
            System.out.println(url.getQuery());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
