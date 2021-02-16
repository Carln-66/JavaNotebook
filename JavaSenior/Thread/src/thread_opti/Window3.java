package thread_opti;

/**
 * @Auther: Carl
 * @Date: 2021/02/06/16:40
 * @Description: 使用同步方法实现Runnable接口线程安全问题
 *
 *              关于同步方法的总结
 *              1. 同步方法依然涉及到同步监视器，只是不需要显式的声明
 *              2. 非静态的同步方法，同步监视器时：this
 *              3. 对于静态方法，同步监视器是当前类本身
 *
 */
public class Window3 {
    public static void main(String[] args) {
        WindowTest3 window = new WindowTest3();

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

class WindowTest3 implements Runnable {
    private int ticket = 100;

    public void run() {
        while (true) {

        }
    }

    //同步方法
    public synchronized void show(){    //同步监视器：this
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
            ticket--;
        }

    }
}
