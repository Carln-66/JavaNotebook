import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther: Carl
 * @Date: 2021/02/20/16:40
 * @Description: 了解类的加载器
 */
public class ClassLoaderTest {
    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用系统类加载器加载的getParent()：获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        //无法获取引导类加载器
        //引导类加载器：主要负责加载Java的核心类库。无法加载自定类
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        ClassLoader loader = String.class.getClassLoader();
        System.out.println(loader);
    }

    /*
        Properties: 用来读取配置文件
     */
    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        //此时文件默认为当前module下
        //读取配置文件
        //方式一
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);

        //方式二：使用ClassLoader
        //配置文件默认识别为当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user + ", password = " + password);
    }
}
