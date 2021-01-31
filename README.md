# JavaNotebook
##### Carl的Java笔记本

### Java三大特点
特点一：面向对象
+ 两个基本概念：类和对象
+ 三大特性：封装性，继承性，多态性

特点二：健壮性
+ 吸收了C/C++语言的特点但是去掉了其影响程序健壮性的部分（例如指针、内存申请与释放等），提供了一个相对安全的内存管理和访问机制

特点三：跨平台性
+ 通过Java语言编写的应用程序在不同的系统平台上都能够运行。

### Java的两种核心机制
+ Java虚拟机(Java Virtual Machine)
    + JVM是一个虚拟的计算机，具有指令集并使用不同的储存区域。负责执行指令，管理数据、内存、寄存器。
    + 对于不同的平台(Windows、Mac OS、Linux)有不同的虚拟机。
    + 只有当某平台提供了对应的虚拟机时，java程序才能够在此平台上运行。
    + java虚拟机机制屏蔽了底层运行平台的差别，真正实现了一次编译，到处运行
+ 垃圾回收机制(Garbage Collection)
    + 将不再运行的空间回收
    + 垃圾回收在Java程序运行过程中自动进行，程序员无法精确控制和干预。
    + GC的基本原理：对于GC来说，当程序员创建对象时，GC就开始监控这个对象的地址、大小以及使用情况。通常，GC采用有向图的方式记录和管理堆(heap)中的所有对象。通过这种方式确定哪些对象是"可达的"，哪些对象是"不可达的"。当GC确定一些对象为"不可达"时，GC就有责任回收这些内存空间。可以。程序员可以手动执行System.gc()，通知GC运行，但是Java语言规范并不保证GC一定会执行。

    
**但是Java程序同样会出现内存泄漏和内存溢出问题！**

### JDK、JRE
JDK(Java Development Kit)
Java开发工具包
JDK是提供给Java开发人员使用的，其中也包含了JRE。
+ 其中的开发工具：编译工具(javac.exe)打包工具(jar.exe)等

JRE(Java Runtime Environment)
其中包含Java虚拟机(JVM)和Java程序所需要的核心类库等等。



