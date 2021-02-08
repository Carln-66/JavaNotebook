package date_time;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: Carl
 * @Date: 2021/02/08/11:00
 * @Description: Calendar抽象类的使用
 */
public class CalendarTest {

    @Test
    public void test() {

        //1.实例化
        //方式一：创建子类(GregorianCalendar)的对象
        //方式二：调用其静态方法(getInstance())
        Calendar calendar = Calendar.getInstance();

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //set()：将日期强制设置
        calendar.set(Calendar.DAY_OF_MONTH, 4);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH, 15);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime()：Calendar ---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime()：Date ---> Calendar
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}
