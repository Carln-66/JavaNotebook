package ControlFlow;

import java.util.Scanner;
/**********************************
 4. 多重选择： switch语句
 如果想建立一个包含四个选项的菜单系统，可以使用下列代码
 Scannerin = new Scanner(System.in);
 System.out.print("Select an option(1,2,3,4)");
 int choice = in.nextInt();
 switch(choice){
 case 1;
 . . .
 break;
 case 2;
 . . .
 break;
 case 3;
 . . .
 break;
 case 4;
 . . .
 break;
 default;
 break;
 }
 switch语句从与选项值相匹配的case标签开始执行，知道遇到break语句，或者执行到switch语句的结束出位置。如果没有相匹配的case标签，
 而有default子句就执行这个子句。
 case的标签可以是：
 * 类型为char/byte/short或int的常量表达式
 * 枚举常量
 * Java7开始，case标签还可以是字符串字面量。

 continue语句，与break语句一样，他将终端正常的控制流程。
 continue语句将控制转移到内层循环的首部。
 例如：
 Scanner in = new Scanner(System.in);
 while(sum < goal);
 {
    System.out.print("Enter a number");
    n = in.nextInt();
    if (n < 0) continue;
    sum += n;
 }
 如果n<0， 则continue语句越过了当前循环体的剩余部分，立刻跳到循环首部。
 如果将continue语句用于for循环中，就可以调到for循环的“更新”部分。
 例如
 for (count = 1; count <= 100; count++){
 System.out.println("输入一个数字，减1退出");
 n = in.nextInt();
 if (n < 0) continue;
 sum += n;
 }
 如果n < 0，则continue语句将跳到count++语句。

 还有一种带标签的额continue语句，将跳到与标签匹配的循环的首部。
 *********************************/



public class ControlFlow3 {
    public static void main(String[] args) {

    }
}
