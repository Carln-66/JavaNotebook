package Thread.exer;

/**
 * @Auther: Carl
 * @Date: 2021/02/06/18:41
 * @Description: 两个账户分别向同一个账户存3000元，每次存1000，存三次。每次存完打印账户余额。(存在线程安全问题)
 *
 * 利用继承双线程共享数据方法
 * public Account{
 *
 * }
 * class Customer extends Thread{
 *     private Account acct;
 *
 *     public Customer(Customer acct){
 *         this.acct = acct;
 *     }
 * }
 * public class AccountTest{
 *     public static void main(String[] args){
 *         Account acct = new Account();
 *
 *         Customer c1 = new Customer();
 *         Customer c2 = new Customer();
 *     }
 * }
 *
 *
 *
 */

class CustomerTest implements Runnable{

    private int balance = 0;

    @Override
    public void run() {
            for (int i = 0; i < 3; i++) {
                deposit(1000);
            }
    }

    public synchronized void deposit(double amount){
        if (amount > 0){

            balance += amount;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "存款，余额为：" + balance);
        }
    }
}

public class Customer {

    public static void main(String[] args) {
        CustomerTest customerTest = new CustomerTest();

        Thread thread1 =new Thread(customerTest);
        Thread thread2 =new Thread(customerTest);

        thread1.setName("用户一");
        thread2.setName("用户二");

        thread1.start();
        thread2.start();
    }

}
