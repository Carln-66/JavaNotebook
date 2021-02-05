package Thread.exer;

/**
 * @Auther: Carl
 * @Date: 2021/02/05/10:54
 * @Description: 创建两个分线程，其中一个遍历100以内的偶数，另一个线程遍历100以内的奇数
 *
 */
public class test {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        myThread1.start();
        myThread2.start();
    }

}

class MyThread1 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread() + ": " + i);
            }
        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread() + ": " + i);
            }

        }
    }
}