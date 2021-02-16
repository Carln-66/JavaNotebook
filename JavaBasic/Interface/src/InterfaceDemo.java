/**
 * @Auther: Carl
 * @Date: 2021/02/03/17:10
 * @Description:
 */
public class InterfaceDemo {
}

class Computer{ //interface_test.USB usb = new interface_test.Flash();
    public void transferData(USB usb){
        usb.start();
        System.out.println("具体传输数据的细节");
        usb.stop();
    }
}

interface USB{
    //常量：定义了长、款、最大最小的涮熟速度等
    void start();
    void stop();
}

class Flash implements USB{

    @Override
    public void start() {
        System.out.println("U盘开始工作");
    }

    @Override
    public void stop() {
        System.out.println("U盘结束工作");
    }
}

class Printer implements USB{

    @Override
    public void start() {
        System.out.println("打印机开启工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作");
    }
}