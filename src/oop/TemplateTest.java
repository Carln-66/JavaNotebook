package oop;

/**
 * @Auther: Carl
 * @Date: 2021/02/03/9:31
 * @Description: 抽象类的应用，模板方法的设计模式
 */
public class TemplateTest {
    public static void main(String[] args) {
        Template t = new SubTemplate();
        t.spendTime();
    }
}

abstract class Template {
    //计算一段代码代码执行索要花费的的时间
    public void spendTime() {
        long start = System.currentTimeMillis();
        code();     //不缺定的部分，易变的部分。所以需要定义抽象
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));
    }

    public abstract void code();
}

class SubTemplate extends Template {

    @Override
    public void code() {
        for (int i = 2; i <= 1000; i++) {
            boolean isFlag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isFlag = false;
                    break;
                }
            }
            if (isFlag) {
                System.out.println(i);
            }
        }
    }
}
