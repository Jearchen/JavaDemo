## 简单的BIO服务器
介绍：

  1. Socket\
&emsp;bind方法：Socket绑定本地地址\
&emsp;connect方法：连接目标地址，若不写bind则本地的端口随机生成。若要指定，则需要保证本地端口没有被占用。\
&emsp;读取一行数据:\
&emsp;&emsp;获取InputStream: 使用Socket类的getInputStream()\
&emsp;&emsp;读数据：InputStream是抽象类，read方法的实现可以使用配套的InputStreamReader类的read。但是这个方法主要是将byte转为字符的。想要读一行数据，
则还需使用BufferedReader的readLine方法。\
&emsp;写入一行数据:\
&emsp;&emsp;获取OutputStream：使用Socket类的getOutputStream()\
&emsp;&emsp;写数据: OutputStream是抽象类，write方法的实现使用的是OutputStreamReader类，这个类同样面向字符，且也不提供写一行。使用BufferedWriter的write
方法，并使用newLine()在字符中添加行结束符。写完之后调用flush()方法。
        
  2. ServerSocket\
&emsp;&emsp;accept方法：获取服务器监听的端口上是否有新的连接，并返回Socket对象。
     
  3. 需要解决空格在服务端显示换行。
