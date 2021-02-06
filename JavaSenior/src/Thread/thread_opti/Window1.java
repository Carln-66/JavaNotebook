package Thread.thread_opti;


/**
 * @Auther: Carl
 * @Date: 2021/02/06/15:59
 * @Description: 使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 * 在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 */
public class Window1 {
        public static void main(String[] args) {
            WindowTest1 window1 = new WindowTest1();
            WindowTest1 window2 = new WindowTest1();
            WindowTest1 window3 = new WindowTest1();

            window1.setName("窗口一");
            window2.setName("窗口二");
            window3.setName("窗口三");

            window1.start();
            window2.start();
            window3.start();

        }

    }
    class WindowTest1 extends Thread{

        private static int ticket = 100;
        static Object obj = new Object();

        @Override
        public void run(){
            while(true){
                //synchronized(obj) {
                //下面错误
                //synchronized(this){
                synchronized(Window1.class){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (ticket > 0) {
                        System.out.println(getName() + "卖票，票号为：" + ticket);
                        ticket--;
                    } else {
                        break;
                    }
                }
            }
        }
    }

