package com.jeartech.ThreadDemo;

public class newRuning extends  Thread{
    public void run() {
        System.out.println("washmachine is  Runing!");
    }
    public static void main1(String[] args) {
        newRuning machine =new newRuning();
        machine.start();
    }
}

