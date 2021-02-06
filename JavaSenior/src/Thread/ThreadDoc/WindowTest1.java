package Thread.ThreadDoc;

/**
 * @Auther: Carl
 * @Date: 2021/02/06/10:04
 * @Description: 创建三个接口卖票，总票数为100张，使用实现Runnable接口方式
 * 存在线程安全问题，待解决
 */
public class WindowTest1{
    public static void main(String[] args) {
        Window1 window = new Window1();

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

class Window1 implements Runnable{
    private int ticket = 100;

    public void run(){
        while(true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}