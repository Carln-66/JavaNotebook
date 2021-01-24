package ClassAndMethod;

/**************************************************
 包
 Java允许使用包(Package)将类组织到一个集合中。借助包可以方便的组织自己的代码，并将自己的代码与别人提供的代码库分开管理。

 1. 包名
 包名需要具有唯一性。两个相同名的class放在不同包中不会产生冲突。

 2. 类的导入
 一个类可以使用所属包中的所有类，以及其他包中的公共类(public class)。
 可以采用两种方式访问另一个包中的公共类。
 * 使用完全限定名(fully qualified name)；也就是包名后面跟着类名。例如
 java.time.LocalDate today = java.time.LocalDate.now();
 * 更简单且采用的方式是采用import语句，使用类时，就不必写出类的全名了。
 可以用import语句导入一个特定的类或者整个包。import语句应该位于源文件的顶部(但位于package语句的后面)。

 3. 静态导入
 有一种import语句允许导入静态方法和静态字段，而不只是类。
 例如，如果在源文件顶部，添加一条指令：
 import static java.lang.System.*;
 就可以使用System类的静态方法和静态字段，而不必加类名前缀：
 out.println("Hi, I'm Carl!")        //省略System.out
 exit(0)     //省略System.exit
 另外，还可以导入特定的方法或字段
 import ststic java.lang.System.out;

 4. 在包中增加类
 想将类放入包中，就必须将包的名字放在源文件的开头，即放在定义这个包中各个类的代码之前。例如：
 package com.abc.corejava;
 如果没有在源文件中放置package语句，这个源文件中的类就属于无名包(unnamed package)。无名包没有包名。
 */



public class Package {
}
