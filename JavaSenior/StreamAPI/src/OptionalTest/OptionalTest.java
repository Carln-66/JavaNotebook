package OptionalTest;

import org.junit.Test;

import java.util.Optional;

/**
 * @Auther: Carl
 * @Date: 2021/02/26/12:41
 * @Description: Optional类：为了在程序中避免出现空指针异常而创建的
 *  常用方法：ofNullable(T t)
 *          orElse(T t)
 *
 */
public class OptionalTest {

    /*
        Optional.of(T t): 创建一个Optional实例，t必须非空
        Optional.empty(): 创建一个空的Optional实例
        Optional.ofNullable(T t): t可以为null
     */
    @Test
    public void test1(){
        Girl girl = new Girl();
//        girl = null;
        //of(T t): 保证t是非空的
        Optional<Girl> optionalGirl = Optional.of(girl);
    }

    @Test
    public void test2(){
        Girl girl = new Girl();
        girl = null;
        //ofNullable(T t): t可以是空的
        Optional<Girl> optionalGirl1 = Optional.ofNullable(girl);
        System.out.println(optionalGirl1);
    }

    @Test
    public void test3(){
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    public String getGirlName(Boy boy){
        //会出现空指针
        return boy.getGirl().getName();
    }

    @Test
    public void test4(){
        Boy boy = new Boy();
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    //优化getGirlName()方法，避免出现空指针异常
    public String getGirlName1(Boy boy){
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;
    }

    //使用Optional类的getGirlName()

    @Test
    public void test5(){
        Boy boy = null;
        boy = new Boy();
        boy.setGirl(new Girl("王五"));
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }

    public String getGirlName2(Boy boy){
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        //此时的boy1一定非空
        Boy boy1 = optionalBoy.orElse(new Boy(new Girl("张三")));

        Girl girl = boy1.getGirl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        //此时的girl1一定非空
        Girl girl1 = optionalGirl.orElse(new Girl("李四"));

        return girl1.getName();
    }

}
