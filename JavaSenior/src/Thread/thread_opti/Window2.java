package Thread.thread_opti;

/**
 * @Auther: Carl
 * @Date: 2021/02/06/15:16
 * @Description: 创建三个接口卖票，总票数为100张，使用实现Runnable接口方式
 *              问题：卖票过程中，出现了重票、错票-->线程安全问题
 *              出现原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程也参与进来，操作车票
 *              如何解决：当一个线程在操作ticket的时候，其他线程不能参与进来，知道线程a操作完ticket时候，其他线程a操作完ticket时
 *                      其他线程才可以开始操作ticket。这种情况即使线程a出现了阻塞，也不能改变。、
 *              Java中，通过同步机制解决线程的安全问题
 *                      方式一：同步代码块
 *                          synchronized(同步监视器){
 *                              //需要被同步的代码
 *                          }
 *                       说明：操作共享数据的代码，即为需要同步的代码。--->不能够包含过多或过少代码
 *                       共享数据：多个线程共同操作的变量。如本例中的ticket。
 *                       同步监视器：俗称锁。任何一个类的对象都可以充当锁
 *                       要求：多个线程必须要共用同一把锁
 *
 *                       补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器
 *
 *                      方式二：同步方法
 *                      如果操作数据共享的代码完整的声明在一个方法中我们可以将此方法声明为同步的。
 *
 *                      同步的方式：解决了线程的安全问题。---好处
 *                      操作同步代码时只能有一个线程参与，其他线程等待，相当于是一个单线程的过程，效率低一些。 ---局限性
 */
public class Window2 {
    public static void main(String[] args) {
        WindowTest2 window = new WindowTest2();

        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class WindowTest2 implements Runnable {
    private int ticket = 100;
    Object obj = new Object();

    public void run() {
        while (true) {
//            synchronized(obj){
            synchronized(this) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
