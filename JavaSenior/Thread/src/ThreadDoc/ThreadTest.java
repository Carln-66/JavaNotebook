package ThreadDoc;

/**
 * @Auther: Carl
 * @Date: 2021/02/05/11:45
 * @Description:        多线程创建
 *                  方式一：继承Thread类
 *                      1. 创建一个继承于Thread类的子类
 *                      2. 重写Thread类的run()
 *                      3. 创建Thread类的子类的对象
 *                      4. 通过此对象调用start()
 *          举例：遍历100以内所有偶数
 */


    //1. 创建一个继承于Thread类的子类
    class MyThread extends Thread{

        //2. 重写Thread类中的run()
    @Override
    public void run(){
        for (int i = 1; i < 10000; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }

        }
    }
}
public class ThreadTest{
    public static void main(String[] args) {
        //3. 创建Thread子类的对象
        MyThread thread = new MyThread();

        //4. 通过此对象调用start()
        /*
        * 1. 启动当前线程
        * 2. 调用当前线程的run()
        * */
        thread.start();

        //在main线程中执行
        for (int i = 1; i < 10000; i++) {
            if (i % 2 == 0){
                System.out.println(i + "************************");
            }
        }
    }
}
