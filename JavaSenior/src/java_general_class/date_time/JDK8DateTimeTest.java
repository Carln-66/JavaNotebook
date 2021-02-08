package java_general_class.date_time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Auther: Carl
 * @Date: 2021/02/08/11:28
 * @Description: JDK8中日期和时间的API测试
 *                  JDK8之前，Date类存在一些问题
 *                  可变性：像日期和时间这样的类应该是不可变的。
 *                  偏移性：Date中的年份是从1900开始的，而月份都从0开始。
 *                  格式化：格式化只对Date有用，Calendar则不行。
 *                  此外，它们也不是线程安全的；不能处理闰秒等。
 *
 *                  JDK8中新引入的API
 *                  java.time – 包含值对象的基础包
 *                  java.time.chrono – 提供对不同的日历系统的访问
 *                  java.time.format – 格式化和解析时间和日期
 *                  java.time.temporal – 包括底层框架和扩展特性
 *                  java.time.zone – 包含时区支持的类
 */
public class JDK8DateTimeTest {

    // LocalDate、LocalTime、LocalDateTime类的使用
    //LocalDateTime使用频率更高
    @Test
    public void test1(){
        //获取当前日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of方法：设置指定的年月日时分秒，无偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 05, 12, 14, 32);
        System.out.println(localDateTime1);

        System.out.println("*****************************************************");

        //getXxx()
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getDayOfWeek());
        System.out.println(localDateTime1.getDayOfYear());
        System.out.println(localDateTime1.getMonthValue());

        System.out.println("*****************************************************");

        //不可变性
        //withXxx() 修改时间
        LocalDateTime localDateTime2 = localDateTime1.withDayOfMonth(8);
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime2.getDayOfMonth());

        System.out.println("*****************************************************");

        //plus() 增加时间
        LocalDateTime localDateTime3 = localDateTime1.plusWeeks(5);
        System.out.println(localDateTime1.getDayOfYear());
        System.out.println(localDateTime3.getDayOfYear());
        System.out.println();
        //minus() 减去时间
        LocalDateTime localDateTime4 = localDateTime1.minusYears(5);
        System.out.println(localDateTime1.getYear());
        System.out.println(localDateTime4.getYear());
    }
}
