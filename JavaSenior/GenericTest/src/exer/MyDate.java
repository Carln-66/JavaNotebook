package exer;

/**
 * @Auther: Carl
 * @Date: 2021/02/12/15:31
 * @Description:
 */
public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "年" + month + "月" + day + "日";
    }

    @Override
    public int compareTo(MyDate o) {
        int minusYear = this.getYear() - o.getYear();
        if (minusYear != 0) {
            return minusYear;
        } else {
            int minusMonth = this.getMonth() - o.getMonth();
            if (minusMonth != 0) {
                return minusMonth;
            }
            return this.day - o.day;
        }
    }
}

//未指定泛型之前
//    @Override
//    public int compareTo(Object o) {
//
//        Employee employee1 = new Employee();
//        Employee employee2 = new Employee();
//
//        if (o instanceof MyDate) {
//            MyDate myDate = (MyDate) o;
//
//            int minusYear = this.getYear() - myDate.getYear();
//            if (minusYear != 0) {
//                return minusYear;
//            } else {
//                int minusMonth = this.getMonth() - myDate.getMonth();
//                if (minusMonth != 0) {
//                    return minusMonth;
//                }
//                return this.day - myDate.day;
//            }
//        } else {
//            throw new RuntimeException("输入数据类型不匹配");
//        }
//    }


