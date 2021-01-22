import java.util.Scanner;

/********************************
 输入与输出
 1. 读取输入
 要通过控制台进行输入，首先需要构造一个与”标准输入流“System.in关联的Scanner对象。
 * Scanner类定义在Java.util包中。当使用的类不是定义在基本java.lang包中时，一定要使用import指令导入相应的包

 2. 格式化输出
 用
    System.out.printlin("x");
 将数值x输出到控制台。这条命令将以x的类型所允许的最大非0数位个数打印输出x。
    double x = 10000.0 / 3.0
    System.out.println(x);  //输出3333.333333335
 如果希望显示货币就会出现问题。Java中沿用了C语言函数库中的printf方法。例如调用
    System.out.printf("%8.2f", x);  //输出3333.33
 会以一个字段宽度打印x：这包括8个字符，另外精度为小数点后2字符
 * 可以为printf提供多个参数。如
    System.out.printf("Hello, %s.Next year, you'll be %d", name age);
 * 用于printf的转换符和标志见《Java核心技术卷Ⅰ》P58

 可以使用静态的String.format方法创建一个格式化的字符串，从而不打印输出
    String message = String.format("Hello, %s. Next year, you'll be %d", name, age);    //将结果作为一个字符串保存在message中

 3. 日期格式化输出
 利用java.time包对Date类进行格式化输出。例如
    System.out.printf("%tc", new Date());
 * 更多格式见《Java核心技术卷Ⅰ》P59

 4. 文件输入与输出
 读取文件需要构造一个Scanner对象，如下
 Scanner in = new Scanner(Path.of("my file.txt"), StandardCharsets.UTF_8);
 * 如果文件名中包含反斜杠付好，需要在每个反斜杠之间再加一个额外的反斜杠转义:"c:\\mydirectory\\myfile.txt"。
 * 如果想写入文件，就需要构造一个PrintWriter对象。在构造器(constructor)中，需要提供文件名和字符编码：
    PrintWriter out = new PrintWriter("myfile.txt", StandardCharsets.UTF_8);
 **********************************/




public class InputOutput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = in.nextLine();        //调用nextLine方法是因为在输入行中有空能包含一个空格

        //想要读取一个单词（一空白符作为分隔符），可以调用
        //String firstName = in.next();

        System.out.println("How old are you?");
        int age = in.nextInt();         //读取整数就使用nextInt方法
        /*与此类似，如果调用浮点数就用nextDouble*/

        int nextYearAge = age + 1;      //计算明年的年龄，也可以直接在打印行中进行计算

        System.out.println("Hello, " + name + ". Next year, you'll be " + nextYearAge + ".");

        System.out.printf("Hello, %s.Next year, you'll be %d", name, nextYearAge);

        String message = String.format("Hello, %s. Next year, you'll be %d", name, age);
    }
}

/*
 *
 *
 * 因为输入是可见的，所以Scanner类不适用于从控制台读取密码。
 * 在Java6后像读取密码可以利用以下代码实现
 * Console cons = System.console();
 * String username = cons.readLine("User name");
 * char[] passwd = cons.readPassword("Password");
 *
 *
 *
 */
