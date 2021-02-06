package Thread.exer;

/**
 * @Auther: Carl
 * @Date: 2021/02/06/19:26
 * @Description: 线程通讯举例: 使用两个线程打印1-100，线程1，线程2交替打印
 *
 * 涉及到的三个方法
 * wait(): 一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 * notify(): 一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，就唤醒优先级高的那个。
 * notifyAll(): 一旦执行此方法，就会唤醒所有被wait的线程。
 *
 * wait(), notify(), notifyAll()三个方法必须使用在同步代码块或同步方法中。
 * wait(), notify(), notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。否则会出现IllegalMonitorStateException异常
 * wait(), notify(), notifyAll()三个方法是定义在java.lang.Object包中的。
 *
 * 题目：
 * sleep和wait方法的异同
 * 相同点：只要执行，就会使得当前的线程进入阻塞状态
 * 不同点：1. 两个方法声明的位置不同：Thread类中声明sleep()，Object类中声明wait()
 *        2. 调用的要求不同：sleep()可以在任何需要的场景下调用。wait()必须使用在同步代码块或同步方法之中
 *        3. 关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁。
 *
 *
 */

class Number implements Runnable {

    private int number = 1;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                obj.notify();   //唤醒

                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + " 打印： " + number);
                    number++;
                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}


public class CommunicationTest {

    public static void main(String[] args) {
        Number number = new Number();

        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);

        thread1.setName("线程1");
        thread2.setName("线程2");

        thread1.start();
        thread2.start();
    }

}
