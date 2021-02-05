package exceptions;


import org.junit.Test;

/**
 * @Auther: Carl
 * @Date: 2021/02/03/20:01
 * @Description: 异常处理：抓抛模型
 *
 *              过程一："抛"： 程序在正常的执行过程中，一旦出现异常，就会在异常代码出生成一个对应异常类的对象，并将此对象抛出。
 *                      一旦抛出对象，其后的代码便不再执行。
 *
 *                      关于异常的产生：1. 系统自动生成的异常对象
 *                                  2. 手动的生成一个异常对象并抛出(throw)
 *
 *              过程二："抓"：可以理解为异常处理的两种方式：1. try-catch-finally
 *                                                  2.throws
 *
 *              二、try-catch-finally的使用
 *                  try{
 *                      //可能出现异常的代码
 *                  }catch(异常类型1 变量名1){
 *                      //处理异常的方式1
 *                  }catch(异常类型2 变量名2){
 *                      //处理异常的方式2
 *                  }catch(异常类型3 变量名3){
 *                      //处理异常的方式3
 *                  }
 *                  ......
 *                  finally{
 *                      //一定会执行的代码
 *                  }
 *          说明：
 *          1. finally时可选的，不一定要写
 *          2. 使用try将可能出现异常的代码包装起来，执行过程中，一旦出现异常，就会生成一个对应异常类的对象。根据此对象的类型，去
 *          catch种进行匹配。
 *          3. 一旦try中的对象匹配到某一个catch时，就进入catch中进行异常的处理。一旦处理完成，就跳出当前的try-catch结构(在没有
 *          写finally的前提下)，继续执行后面的代码。
 *          4. catch中的异常类型如果没有子父类关系，则谁声明在上，谁声明在下没有影响。
 *              catch中的异常类型如果满足子父类关系，则要求子类一定声明在父类的上面，否则报错。
 *          5. 常用的异常对象处理方式： 1. String getMessage()      2. printStackTrace()
 *          6. 在try结构中声明的变量，除了try结构就不能调用了。可以在try结构体外先声明变量，并赋默认值，即可在结构外调用该变量。
 *          7. try-catch-finally结构可以嵌套。
 *
 *          总结1：使用try-catch-finally处理编译时异常，使得程序在编译时就不再报错，但是运行时仍有可能报错。相当于我们使用
 *              try-catch-finally将一个编译时可能出现的异常延迟到运行时出现。
 *          总结2：开发时，由于运行时异常比较常见，所以我们通常不针对运行时异常编写try-catch-finally。针对于编译时异常，一定要考
 *              虑异常的处理。
 *
 *
 *
 */
public class ExceptionTest1 {
    @Test
    public void test1(){
        String string = "abc";
        try {
            int num = Integer.parseInt(string);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            System.out.println("空指针异常");
        }catch(Exception e){
            System.out.println("出现异常");
        }
    }
}
