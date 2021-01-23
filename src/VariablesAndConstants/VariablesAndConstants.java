package VariablesAndConstants;

/*************************************
 变量与常量

 1. 变量声明（Variable declaration）
 ①Type
 ②Variable name
 ③Operator
 ④Variable data
 *不能用Java保留字作为变量名

 2. 变量初始化
 声明变量后需用赋值语句对变量进行显式初始化。


 public static void main (String[]args){
 int a;          //系统报错: java: 可能尚未初始化变量a
 System.out.println(a);
 }
 }

 3.
 常量
 用关键字final指示常量
 *final表示变量只能被赋值一次，一旦赋值，不能再做修改。
 *习惯上常量名使用全大写。

 ************************************/


public class VariablesAndConstants {
    public static void main(String[] args) {
        final double CM_PER_INCH = 2.54;    //使用final关键词赋值常量
        double paperWidth = 8.5;
        double paperHeight = 11;
        System.out.println("Paper size in centimeters: " + paperWidth * CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
    }
}
