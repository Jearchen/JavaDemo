NIO服务器
使用Java的NIO框架实现的简单服务器。
- 关于ByteBuffer
- JDK中一个基本ByteBuffer有很多基本类型的子类。关于ByteBuffer的使用，包括基本初始化，写模式切换到读模式（flip操作），读模式切到写模式（clear活着compact操作），读数据重播（rewind操作），读中断使用mark标记读的位置。其间涉及到的在机械工业出版社出版的《Java高并发核心编程卷1》Nio篇已经做了详细说明。比一般的博客更能讲的清楚。
- 关于SelectionKey
- Selector在ServerSocketChannel中注册了关心的事件之后，一旦触发，就可以根据key获取到对应的通道，并进行数据的读写。
- SercerSocketChannel和SocketChannel都实现了SelectableChannel的接口，这个接口定义了一系列的标准的非阻塞的函数。单纯的使用slector.select()还是没有排除的轮询的NIO，后面引入Reactor反应模式的模型，使用reactor、handler才能摆脱掉while轮询。这个跟线程进行挂钩。是真正的能用得上的模型。
- 另外,这一段在Linux下面还有一个空轮询的bug。就是selector.select()原本是阻塞的，在客户端断开连接时候会执行，所以需要新建一个Selector进行判断是否空轮询[CSDN空轮询](https://blog.csdn.net/fedorafrog/article/details/113553943)
- 关于Netty
- Netty丢弃了Bytebuffer，使用ByteBuf。使用了多反应器，多线程处理的模式。
- Netty支持应用层支持多协议。底层也是基于NIO。
