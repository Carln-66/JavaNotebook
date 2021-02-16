package Map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: Carl
 * @Date: 2021/02/13/11:46
 * @Description:
 */
public class PropertiesTest {
    //Properties：常用来配置文件。key和value都是String类型
    public static void main(String[] args){
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();

            fis = new FileInputStream("jdbc.properties");
            pros.load(fis);   //加载流对应的文件

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");
            System.out.println("name = " + name + ", password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
