import java.io.File;

/**
 * @Auther: Carl
 * @Date: 2021/02/14/20:05
 * @Description:
 */
public class ListFilesTest {

    public static void main(String[] args) {
        // 递归:文件目录
        /** 打印出指定目录所有文件名称，包括子文件目录中的文件 */

        // 1.创建目录对象
        File dir = new File("D:\\");

        // 2.打印目录的子文件
        printSubFile(dir);
    }

    public static void printSubFile(File dir) {
        // 打印目录的子文件
        File[] subfiles = dir.listFiles();

        for (File f : subfiles) {
            if (f.isDirectory()) {// 文件目录
                printSubFile(f);
            } else {// 文件
                System.out.println(f.getAbsolutePath());
            }

        }
    }
}