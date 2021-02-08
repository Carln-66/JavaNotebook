package date_time;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: Carl
 * @Date: 2021/02/08/9:37
 * @Description: JDK8之前的日期时间的API测试
 * 1. System类中currentTimeMillis();
 * 2. java.util.Date和子类java.sql.Date
 * 3. SimpleDateFormat
 * 4. Calendar
 */
public class DateTimeTest1 {

    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
    1. 两个操作：
        1.1 格式化： 日期---> 字符串
        1.2 解析： 格式化的逆过程，字符串 ---> 日期

    2. SimpleDateFormat的实例化
    * */
    @Test
    public void simpleDateFormatTest() throws ParseException {  //此处抛异常原因为输入字符串与指定格式不匹配
        //实例化SimpleDateFormat：使用默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化： 日期---> 字符串
        Date date = new Date();
        System.out.println(date);

        String s = sdf.format(date);
        System.out.println(s);

        //解析： 格式化的逆过程，字符串 ---> 日期
        String str = "21-1-24 上午10:19";
        Date parse = sdf.parse(str);
        System.out.println(parse);

        System.out.println("/*********************************************/");

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, MMM d, ''yy");     //系统默认示例
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm");  //以指定方式格式化
        String s1 = simpleDateFormat.format(date);
        System.out.println(s1);

        //字符串必须为符合SimpleDateFormat识别的格式(通过构造器参数体现)，否则会抛异常
        Date parse1 = simpleDateFormat.parse("2000年09月05日 23:59");
        System.out.println(parse1);
    }

    @Test
    //字符串"2021-02-28"转换为java.sql.Date
    public void test2() throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date parse2 = simpleDateFormat1.parse("2021-02-28");
        java.sql.Date date1 = new java.sql.Date(parse2.getTime());
        System.out.println(date1);
        System.out.println(date1.getClass());

    }

    @Test
    //"三天打鱼两天晒网"   从2005-01-01开始，问在xxxx年xx月xx日时是在打鱼还是晒网
    //举例： 2021-01-31
    public void test3() throws ParseException {
        Date date = new Date();

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date parse1 = simpleDateFormat1.parse("2005-01-01");
        Date parse2 = simpleDateFormat1.parse("2020-01-31");
        long l = parse2.getTime() - parse1.getTime();

        long l1 = (l / ((1000 * 60 * 60 * 24) + 1) % 5 );
        if (l1 == 3 || l1 ==2 || l1 ==1){
            System.out.println("正在打鱼");
        }else {
            System.out.println("正在晒网");
        }
    }
}
