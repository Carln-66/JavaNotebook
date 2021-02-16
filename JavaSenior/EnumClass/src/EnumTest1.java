/**
 * @Auther: Carl
 * @Date: 2021/02/09/8:49
 * @Description: 使用enum关键字定义枚举类
 *  说明：定义的枚举类默认继承于java.lang.Enum类
 */


public class EnumTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(Season1.class.getSuperclass());
        //toString(): 返回枚举类对象的名称
        System.out.println(summer.toString());
        System.out.println("----------------------------------");
        //values(): 返回所有枚举类对象构成的数组
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        System.out.println("----------------------------------");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }
        System.out.println("----------------------------------");
        //valueOf(String objName): 根据提供的objName，返回与objName同名的枚举类对象
        //如果未找到名为objName的对象，则抛异常：IllegalArgumentException
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        System.out.println("----------------------------------");
        //调用接口
        winter.test();
    }
}

interface Test{
    void test();
}

enum Season1 implements Test{

    //1. 提供当前枚举类的多个对象，多个对象之间用","隔开，末尾对象用";"结束
    SPRING("春天", "温暖"){
        @Override
        public void test() {
            System.out.println("这是一个测试，春天");
        }
    },
    SUMMER("夏天", "炎热"){
        @Override
        public void test() {
            System.out.println("这是一个测试，夏天");
        }
    },
    AUTUMN("秋天", "凉爽"){
        @Override
        public void test() {
            System.out.println("这是一个测试，秋天");
        }
    },
    WINTER("冬天", "寒冷"){
        @Override
        public void test() {
            System.out.println("这是一个测试，冬天");
        }
    };

    //2.声明Season对象的属性: private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3. 私有化类的构造器
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //其他诉求2：提供toString()
    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

//    public void test(){
//        System.out.println("这是一个测试");
//    }
}
