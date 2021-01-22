import java.util.Scanner;

/******************************************
 控制流程

 1. 条件语句
 Java中，条件语句的形式位
    if (condition) statement
 Java中常常希望在某个条件位真的时候执行多条语句。在这种情况下，就可以使用块语句(block statement)，形式为
 {
 statement1
 statement2
 . . .
 }
 例如
 if (yourSales >= target)
 {
    performance = "satisfactory";       //当yourSale大于或等于target时，执行大括号中的所有语句
    bonus = 200;
 }

 Java中，更一般的条件语句如下所示
    if (condition) statement1
    else statement2
 else部分总是可选的。else子句与最邻近的if构成一组

 2. 循环语句
 当条件为true时，while循环执行一条语句（也可以是一个块语句）。一般形式如下
    while (condition) statement
 若开始时循环条件的值为false，那么while循环一次也不执行
 * 如果希望循环体至少执行一次需要使用do/while循环将检测放在最后。语法如下：
    do statement while (condition);
 这种循环语句先执行语句（通常是一个语句块），然后再检测循环条件。如果为true则重复执行语句，然后再次检测循环条件，以此类推。
 *****************************************/

//程序计算需要多长时间才能够储存一定数量的退休金，假定每年存入数量相同的金额，而且利率是固定的。
public class ControlFlow {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("你一年可以存下多少钱？");      //控制台输入每年存入钱数
        double payment = in.nextDouble();

        System.out.println("通货膨胀年增长百分比（%）：");       //控制台输入通货膨胀率
        double rate = in.nextDouble();

        double balance = 0;     //初始化余额
        int year = 0;           //初始化年数

        String input;           //定义输入

        do {
            balance += payment;
            double interest = balance * rate / 100;
            balance += interest;
            year++;

            System.out.printf("在%d年后，你的存款为%,.2f%n", year, balance);
            System.out.print("准备退休吗？（是/否）");
            input = in.next();
        }
        while (input.equals("否"));
    }
}
