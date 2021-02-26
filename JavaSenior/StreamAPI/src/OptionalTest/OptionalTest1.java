package OptionalTest;

import org.junit.Test;

import java.util.Optional;

/**
 * @Auther: Carl
 * @Date: 2021/02/26/16:13
 * @Description:
 */
public class OptionalTest1 {

    @Test
    public void test1() {
        //empty(): 创建的Optional对象内部的value = null;
        Optional<Object> op1 = Optional.empty();
        if (!op1.isPresent()) {  //Optional封装的数据是否为空
            System.out.println("数据为空");
        }
        //如果Optional封装的数据value为空，则get()报错。否则，value不为空时，返回value
//        System.out.println(op1.get());
        System.out.println(op1.isPresent());
    }

    @Test
    public void test2() {
        String str = "hello";
//        str = null;
        //of(T t): 封装数据t生成Optional对象。要求t非空，否则报错。
        Optional<String> stringOptional = Optional.of(str);
        //get()通常与of()搭配使用。用于获取内部的封装的数据
        System.out.println(stringOptional.get());
    }

    @Test
    public void test3() {
        String str = "hello";
        str = null;
        //ofNullable(T t): 封装数据t，赋给Optional内部的value。不要求t非空
        Optional<String> s = Optional.ofNullable(str);
        //orElse(T t)如果Optional内部的value非空，则返回此value值。如果value为空，则返回t。
        String s1 = s.orElse("test");
        System.out.println(s1);
    }
}
