package Thread.ThreadDoc;

/**
 * @Auther: Carl
 * @Date: 2021/02/05/14:34
 * @Description: 创建多线程的方式二：实现runnable接口
 *              1. 创建一个实现了Runnable接口的类
 *              2. 实现类去实现Runnable中的抽象方法：run()
 *              3. 创建实现类的对象
 *              4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 *              5. 通过Thread类的对象调用start()
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        //3. 创建实现类的对象
        MThread mThread = new MThread();
        //4. 将此对象作为参数传递到Thread类的构造器中，创建Thread对象
        Thread thread = new Thread(mThread);
        //5. 通过Thread类的对象调用start()
        thread.setName("线程一");
        thread.start();

        //再启动一个线程，遍历100以内的偶数
        Thread thread1 = new Thread(mThread);
        thread1.setName("线程二");
        thread1.start();
    }
}

//1. 创建一个实现了Runnable接口的类
class MThread implements Runnable{

    //2. 实现类去实现Runnable中的抽象方法: run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
