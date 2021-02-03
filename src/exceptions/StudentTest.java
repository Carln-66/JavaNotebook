package exceptions;

/**
 * @Auther: Carl
 * @Date: 2021/02/03/22:11
 * @Description:
 */
public class StudentTest {
    public static void main(String[] args) {
        try {
            Student s = new Student();
            s.register(-10001);
            System.out.println(s);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

class Student {

    int id;

    public void register(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
//            System.out.println("输入非法");
            //手动抛出异常对象
//            throw new RuntimeException("您的输入非法！");
//            throw new Exception("您的输入非法！");
        throw new MyException("不能输入负数");
        }
    }
}


