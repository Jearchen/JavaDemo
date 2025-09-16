## Java 语法练习
项目结构：

grammer中包含大多数练习代码。测试用例放在test包中。

lib中包含自己写的一些库，在测试用例额外针对jar的测试

util中包含项目中常用到的工具类。不依赖三方库。方便迁移。
#### 包含内容:
+ jdk动态代理
+ 枚举方式
+ 迭代方式
+ socket使用
+ stream流使用
+ 线程使用
+ 实现一个b树

#### 使用指南
1、如何在项目增加枚举类？

jdk5之前参考这个文件:grammer\src\com\jeartech\enumrate\EnumConstant.java

jdk6之后参考这个文件:grammer\src\com\jeartech\enumrate\enumdemo.java

2、如何给一个类增加动态代理？

实现invocationhandler接口，实现反射的基本原理。

3、如何创建一个线程？
+ 新建一个类。实现runnable接口，在run方法里面写执行逻辑，参考grammer\src\com\jeartech\thread\newRuning.java
+ 新建一个类，继承thread类，调用start方法。参考grammer\src\com\jeartech\thread\RunableThread.java

4、如何对项目中的二进制文件进行操作？

文件流基本操作，读入和写入。参考grammer\src\com\jeartech\io\IOstream.java

tips:
>获取当前项目路径：
```java
    String envs = System.getProperty("user.dir");
```

5、如何实现一个BTree?
自己实现的一个二叉树的遍历操作。

6、如何实现一个简单的BIO服务器？

参考grammer\src\com\jeartech\socket\BIO\TCPServer.java

7、如何实现一个简单的NIO服务器？

参考grammer\src\com\jeartech\socket\NIO\RunServer.java

测试文件test\com.jeartech\TestRunningOrder.java

Author: *Jearchen*

Date: *2025/09/16*