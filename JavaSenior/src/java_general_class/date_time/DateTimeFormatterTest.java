package java_general_class.date_time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @Auther: Carl
 * @Date: 2021/02/08/12:54
 * @Description:    DateTimeFormatter:格式化或解析日期、时间。
 *              类似于SimpleDateFormat
 */
public class DateTimeFormatterTest {

    @Test
    public void test(){
        //格式化方法
        // 预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期 ---> 字符串
        LocalDateTime time = LocalDateTime.now();
        String format = dtf.format(time);
        System.out.println(time);
        System.out.println(format);

        System.out.println("***********************************************");

        //解析：字符串 ---> 日期
        TemporalAccessor parse = dtf.parse("2020-02-01T15:42:17.131");
        System.out.println(parse);

        System.out.println("***********************************************");


        //本地化相关的格式：如ofLocalizedDateTime()
        // FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT：适用于LocalDateTime
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String format1 = dateTimeFormatter.format(time);
        System.out.println(format1);

        System.out.println("***********************************************");


        //ofLocalizedDate()
        //FormatStyle.FULL/FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String format2 = formatter.format(time);
        System.out.println(format2);

        System.out.println("***********************************************");

        // 自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日  hh:mm:ss");
        System.out.println(timeFormatter);
        //格式化
        String s = timeFormatter.format(time);
        System.out.println(s);

        System.out.println("***********************************************");

        //解析
        TemporalAccessor parse1 = timeFormatter.parse("2021年02月08日  03:35:26");
        System.out.println(parse1);

    }

}
