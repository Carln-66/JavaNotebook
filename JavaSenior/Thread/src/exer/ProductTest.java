package exer;

/**
 * @Auther: Carl
 * @Date: 2021/02/06/20:07
 * @Description: 生产者/消费者问题
 *              生产者(Producer)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品。店员一次只能持有固定数量的产品(比如：20)，
 *              如果生产者试图生产更多的产品，店员会叫生产者停一下， 如果店中有空位放产品了再通知生产者继续生产，如果店中没有产品了，电源会
 *              告诉消费者等一下，如果店中有产品了在通知消费者来取走产品。
 *
 *              这里有可能产生两个问题：
 *              1. 生产者生产比消费者购买速度快时，消费者会漏掉一些数据没有取到
 *              2。 消费者购买比生产者生产速度快的时候，消费者会取相同的数据。
 *
 */

class Clerk{
    private int productCount = 0;

    //生产产品
    public synchronized void produceProduct() {
        if (productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + "开始生产第 " + productCount + " 个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if (productCount > 0){
            System.out.println(Thread.currentThread().getName() + "：开始消费第 " + productCount + " 个产品");
            productCount--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{      //生产者
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "：开始生产产品...");

        while (true){
            clerk.produceProduct();
        }
    }
}

class Consumer extends Thread{      //消费者
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "：开始消费产品...");
        while (true){
            clerk.consumeProduct();
        }
    }
}

public class ProductTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");

        p1.start();
        c1.start();
    }
}
