package Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: Carl
 * @Date: 2021/02/06/18:21
 * @Description: 解决线程安全问题的方式三：Lock锁 ---JDK5.0新增
 *
 * synchronized()与Lock方法的异同
 * 相同：都可以解决线程安全问题
 * 不同：synchronized机制在执行完相应的同步代码以后，自动释放同步监视器
 *      Lock需要手动的启动同步(lock())，同时结束同步也需要手动实现(unLock())
 *
 * 如何解决线程安全问题？有几种方式
 * 同步代码块，同步方法，lock锁
 *
 */

class Window implements Runnable{
    private int ticket = 100;
    //1. 实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    public void run(){
        while (true){
            try{
                //2. 调用锁定方法lock()
                lock.lock();
                if (ticket > 0){
                    System.out.println(Thread.currentThread().getName() + " 售票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                //3. 调用解锁方法
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();

        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
