package Thread;

/**
 * @Auther: Carl
 * @Date: 2021/02/06/17:08
 * @Description: 使用同步机制将单例模式中的懒汉式改写为线程安全的
 */
public class Singleton {
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    public static synchronized Bank getInstance() {     //线程安全
//        if (instance == null) {
//            instance = new Bank();
//        }
//        return instance;

        //效率更高
        if (instance == null) {
            if (instance == null) {
                instance = new Bank();
            }
        }
        return instance;
    }
}