/**
 * @Auther: Carl
 * @Date: 2021/02/23/12:40
 * @Description:
 *  静态代理举例
 *  特点：代理类和被代理类在编译期间就被确定下来
 *
 */

interface ClothFactory{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory clothFactory;  //用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂进行一些准备工作");
        clothFactory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}

public class StaticProxy {
    public static void main(String[] args) {

        //创建被代理类的对象
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        //创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);

        proxyClothFactory.produceCloth();
    }
}
