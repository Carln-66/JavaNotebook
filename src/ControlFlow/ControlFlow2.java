package ControlFlow;

import java.util.Scanner;

/**
 3.确定循环
 for循环是支持迭代循环的一种通用结构，有一个计数器或者类似的变量控制迭代次数，每次迭代后这个变量会更新。
 for语句的第一部分通常是对计数器初始化；第二部分给出每次新一轮循环执行前要检测的循环条件；第三部分指定如何更新计数。
 当for语句的第1部分胜面了一个变量之后这个变量的作用域就扩展到了这个for循环体的末尾。
    for (int i = 1; i < =10; i++) { ...
 }  //i的作用域截止于此
 特别指出，如果在for语句内部定义一个变量，这个变量不能再循环体之外使用
    int i;
    for (i = 1; i <= 10; i++){ ...
    }
 此外，可以在不同的for循环中定义同名变量
    for (int i = 1;  i<= 10; i++){...
    }
    for (int i = 11; i <= 20; i++){...
    }
 for循环是while循环的一种简化形式。如
    for (int i = 1; i <= 10; i++)
        System.out.println("Counting down..." + i);
 可以重写为
 int i = 1;
 while (i >= 10){
    System.out.println("Counting down..." + i);
    i++;
 }
 */


//程序功能，从n个数字中取k个数字来抽奖，计算中奖概率
public class ControlFlow2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("总共有多少数字？");
        int k = in.nextInt();

        System.out.println("你想要抽取几个数字？");
        int n = in.nextInt();

        int prob = 1;
        for (int i = 1; i <= n; i++)
            prob = prob * (k - i + 1) / i;

        System.out.printf("您中奖的概率为：1/" + prob + "，祝你好运！");
    }
}
