import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Auther: Carl
 * @Date: 2021/02/16/23:58
 * @Description:
 */
public class FileUtilsTest {
    public static void main(String[] args) {

        File srcFile = new File("JavaSenior\\IO\\头像.jpg");
        File destFile = new File("JavaSenior\\IO\\复制头像.jpg");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
