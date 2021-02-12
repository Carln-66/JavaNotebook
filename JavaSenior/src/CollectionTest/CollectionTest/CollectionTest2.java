package CollectionTest.CollectionTest;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: Carl
 * @Date: 2021/02/10/9:18
 * @Description: Collection接口中和声明的方法的测试
 * <p>
 * 着重注意的是：
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类必须要重写equals()。因为Collection中的方法很多要调用equals()
 */
public class CollectionTest2 {

    @Test
    public void test1() {

        Collection collection = new ArrayList();
        collection.add(new Person("hzy", 23));
        collection.add("lmx");
        collection.add(689);
        collection.add(new String("aaa"));

        //1. contains(Object obj): 判断当前集合中是否包含obj
        System.out.println("*****************contains(Object obj)********************");
        boolean contains = collection.contains(123);
        System.out.println(contains);
        System.out.println(collection.contains(new String("aaa"))); //true
        System.out.println(collection.contains(new Person("hzy", 23))); //false--->true

        System.out.println();

        //2. containsAll(Collection collection1): 判断形参collection1中所有元素是否都存在于当前集合中
        System.out.println("*****************containsAll(Collection collection1)********************");
        Collection collection1 = Arrays.asList(new Person("hzy", 23), 689);
        boolean containsAll = collection.containsAll(collection1);
        System.out.println(containsAll);

        System.out.println();

        //3. remove(Object obj):
        System.out.println("*****************remove(Object obj)********************");
        boolean remove = collection.remove(156);
        System.out.println(remove);

        System.out.println();

        //4. removeAll(Collection collection1): 从当前集合中移除collection1中所有的元素
        System.out.println("*****************removeAll(Collection collection1)********************");
        System.out.println(collection.toString());
        System.out.println();
        Collection collection2 = Arrays.asList(689, "aaa");
        collection.removeAll(collection2);
        System.out.println(collection);
        System.out.println(collection.toString());

        System.out.println();
    }

    @Test
    public void test2() {

        Collection collection = new ArrayList();
        collection.add(new Person("hzy", 23));
        collection.add("lmx");
        collection.add(689);
        collection.add(new String("aaa"));

        //5. collection.retainAll(): 获取当前集合和collection集合的交集，并返回当前集合
        System.out.println("*****************retainAll(Collection collection)********************");
        Collection collection2 = Arrays.asList(689, "aaa", "hello", new Person("abc", 996));
        collection.retainAll(collection2);
        System.out.println(collection);

        System.out.println();
    }

    @Test
    public void test3(){

        Collection collection = new ArrayList();
        collection.add(new Person("hzy", 23));
        collection.add("lmx");
        collection.add(689);
        collection.add(new String("aaa"));

        Collection collection1 = new ArrayList();
        collection1.add(new Person("hzy", 23));
        collection1.add("lmx");
        collection1.add(689);
        collection1.add(new String("aaa"));

        //6. equals(Object obj): 判断当前集合和形参中所有的元素是否相等，若相等返回true，否则返回false。
        System.out.println("*****************equals(Object obj)********************");
        System.out.println(collection.equals(collection1));
    }

    @Test
    public void test4(){

        Collection collection = new ArrayList();
        collection.add(new Person("hzy", 23));
        collection.add("lmx");
        collection.add(689);
        collection.add(new String("aaa"));

        //7. hashCode(): 返回当前对象的哈希值
        System.out.println("*****************hashCode()********************");
        System.out.println(collection.hashCode());

        System.out.println();

        //8. toArray(): 集合--->数组
        System.out.println("*****************toArray()********************");
        Object[] array = collection.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println();

        //asList(): 调用Arrays类的静态方法将 数组--->集合
        System.out.println("*****************asList()********************");
        List<Object> asList = Arrays.asList(array);
        System.out.println(asList);

        List list = Arrays.asList(new Integer[]{123, 456});  //[[I@621be5d1], 输出地址值，认为存储了一个元素。解决方法：new Integer[]{};
        System.out.println(list);

        System.out.println();

    }

    class Person {
        private String name;
        private int age;

        public Person() {

        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            return;
        }

        public int getAge() {
            return this.age;
        }

        public void setAge(int age) {
            return;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
    }
}

