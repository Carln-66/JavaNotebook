package java_general_class.date_time;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @Auther: Carl
 * @Date: 2021/02/08/12:05
 * @Description:    Instant类
 *              类似于java.util.Date
 */
public class InstantTest {

    @Test
    public void test1(){
        //获取GMT标准时间
        Instant now = Instant.now();
        System.out.println(now);

        //增加时间的偏移量
        OffsetDateTime time = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(time);

        //获取自1970年1月1日0时0分0秒(UTC)开始的毫秒数 ---> Date类的getTime()
        long epochMilli = now.toEpochMilli();
        System.out.println(epochMilli);

        //ofEpochMilli(): 通过给定的毫秒数获取Instant实例 ---> Date(long millis)
        Instant milli = Instant.ofEpochMilli(1612758124897L);
        System.out.println(milli);

    }
}
