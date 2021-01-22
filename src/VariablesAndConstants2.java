/*************************
 如果想让某个常量在一个类的额多个方法中使用，将其称为类常量（class constant）
 *用关键词static final设置一个类常量。
 *************************/


public class VariablesAndConstants2 {
    public static final double CM_PERINCH = 2.54;   //用static final赋值在多个方法中使用的常量

    public static void main(String[] args) {
        double paperWidth = 8.5;
        double paperHeight = 11;
        System.out.println("Paper size in centimeters: " + paperWidth * CM_PERINCH + paperHeight * CM_PERINCH);
    }
}
