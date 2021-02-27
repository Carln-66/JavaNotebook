import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @Auther: Carl
 * @Date: 2021/02/27/14:36
 * @Description:
 */
public class JDK11Test {
    //java11中的新特性一：String中新增的方法
    @Test
    public void test1(){
        //isBlank(): 判断字符串是否为空白
        System.out.println("  \t  \n  \t".isBlank());

        //strip(): 去除首尾的空白
        System.out.println("-----" + "   \t  \n abc \t\n  ".strip() + "---");
        System.out.println("-----" + "   \t  \n abc \t\n  ".trim() + "---");

        //stripTrailing(): 去除尾部空格
        System.out.println("-----" + "   \t  \n abc \t\n  ".stripTrailing() + "---");

        //stripLeading(): 去除首部空格
        System.out.println("-----" + "   \t  \n abc \t\n  ".stripLeading() + "---");

        //repeat(int count):
        String str = "123";
        String repeat = str.repeat(3);
        System.out.println(repeat);

        //lines().count():
        String str1 = "abc\ndefg";
        System.out.println(str1.lines().count());
    }

    //java11新特性二：Optional新增的方法
    @Test
    public void test2(){
        Optional<Object> optional = Optional.empty();
        System.out.println(optional.isEmpty());     //判断内部的value是否为空
        System.out.println(optional.isPresent());   //判断内部的value是否存在

        optional = Optional.of("123");
        //orElseThrow(): value非空，返回value，否则抛异常NoSuchElementException
        var obj = optional.orElseThrow();
        System.out.println(obj);

        //or: value非空，返回对应的Optional；value为空，返回新参封装的Optional
        Optional<String> optional1 = Optional.of("你好");
        optional = Optional.empty();
        Optional<Object> optional2 = optional.or(() -> optional1);
        System.out.println(optional2);
    }

    //java11新特性三：局部变量类型推断的升级
    @Test
    public void test3(){
        //错误的形式: 必须要有类型, 可以加上var
        //Consumer<String> con1 = (@Deprecated t) -> System.out.println(t.toUpperCase());
        //正确的形式:
        //使用var的好处是在使用lambda表达式时给参数加上注解。
        Consumer<String> con2 = (@Deprecated var t) -> System.out.println(t.toUpperCase());
    }

    //Java11新特性四：HttpClient替换原有的HttpURLConnection
    public void test4(){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request =
            HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
            HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
            HttpResponse<String> response = client.send(request, responseBodyHandler);
            String body = response.body();
            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void test5(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =
                HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> sendAsync =
                client.sendAsync(request, responseBodyHandler);
        sendAsync.thenApply(t -> t.body()).thenAccept(System.out::println);
        //HttpResponse<String> response = sendAsync.get();
        //String body = response.body();
        //System.out.println(body);
    }
}
