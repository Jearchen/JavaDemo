package com.jeartech.ThreadDemo;
//测试多线程执行顺序
public class TestRunningOrder extends Thread{

    private String threadName;

    @Override
    public void run() {
        System.out.println(this.threadName);
    }

    public TestRunningOrder(String threadName) {
        this.threadName =threadName;
    }

    public static void main(String[] args) {
        Thread t1 = new TestRunningOrder("t1");
        Thread t2 = new TestRunningOrder("t2");
        Thread t3 = new TestRunningOrder("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
