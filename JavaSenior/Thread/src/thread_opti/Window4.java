package thread_opti;

/**
 * @Auther: Carl
 * @Date: 2021/02/06/16:55
 * @Description: 使用同步方法处理继承Thread类的方式中的线程安全问题
 */
public class Window4 {
    public static void main(String[] args) {
        WindowTest4 window1 = new WindowTest4();
        WindowTest4 window2 = new WindowTest4();
        WindowTest4 window3 = new WindowTest4();

        window1.setName("窗口一");
        window2.setName("窗口二");
        window3.setName("窗口三");

        window1.start();
        window2.start();
        window3.start();
    }
}

class WindowTest4 extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
        }
    }

    //    private synchronized void show(){    //同步监视器有三个：windows1, window2, window3。错误
    private static synchronized void show() {        //同步监视器：Window4.class
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

