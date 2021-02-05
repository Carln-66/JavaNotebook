package Thread.ThreadDoc;

/**
 * @Auther: Carl
 * @Date: 2021/02/05/12:37
 * @Description:    测试Thread中的方法
 *                  1. start()：启动当前线程；调用当前线程的run()
 *                  2. run():通常需要重写Thread类中的此方法，将创建的线程需要执行的操作声明在此方法中
 *                  3. currentThread()：静态方法，返回当前代码的线程
 *                  4. getName()：获取当前线程名字
 *                  5. setName()：设置当前线程的名字
 *                  6. yield()：释放当前CPU的执行权
 *                  7. join()：在线程a中调用线程b的join()，此时线程a进入阻塞状态，直到线程b完全执行完之后，线程a才结束阻塞状态。
 *                  8. stop()：已过时。当执行此方法时，强制结束当前线程。
 *                  9. sleep(long millisecond)：让当前线程"睡眠"指定的millisecond毫秒。在指定的millisecond毫秒时间内，当
 *                      前线程是阻塞状态。
 *                  10. isAlive()：判断当前线程是否存活
 *
 *                  线程的优先级
 *                  1. MIN_PRIORITY: 1
 *                  2. NORM_PRIORITY: 5 ---> 默认优先级
 *                  3. MAX_PRIORITY: 10
 *
 *                  如何获取和设置当前线程的优先级
 *                  getPriority()：获取线程的优先级
 *                  setPriority()：设置线程的优先级
 *                  说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，高优先级的线程高概率情况下被执行。并不意味着
 *                      只有当高优先级的线程执行完以后，低优先级的线程才执行
 */
public class ThreadMethod {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread("线程一");

//        helloThread.setName("遍历100以内的数");

        //设置分线程的优先级
        helloThread.setPriority(Thread.MAX_PRIORITY);

        helloThread.start();

        //给主线程命名和优先级
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(10);

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
            System.out.println(Thread.currentThread().getName() + "：" + Thread.currentThread().getPriority() + "："+ i);
            }
//            if (i == 20){
//                try {
//                    helloThread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(helloThread.isAlive());
    }
}


class HelloThread extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + "：" + Thread.currentThread().getPriority() + "：" + i);
            }
            if (i % 20 ==0){
                this.yield();
            }
        }
    }

    public HelloThread(String name){
        super(name);
    }
}