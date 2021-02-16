package ThreadDoc;

/**
 * @Auther: Carl
 * @Date: 2021/02/05/13:41
 * @Description: 创建窗口买票，总票数为100张
 *              存在线程安全问题
 */
public class WindowTest {
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();

        window1.setName("窗口一");
        window2.setName("窗口二");
        window3.setName("窗口三");

        window1.start();
        window2.start();
        window3.start();

    }

}
class Window extends Thread{

    private static int ticket = 100;

    @Override
    public void run(){
        while(true){
            if (ticket > 0){
                System.out.println(getName() + "卖票，票号为：" + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}