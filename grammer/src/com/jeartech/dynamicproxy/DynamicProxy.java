package com.jeartech.DynamicProxy;

/**
 * 动态代理实例
 * 1、
 */


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private  Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy,Method method ,Object[] args) throws  Throwable{
        System.out.println("before invoke");
        method.invoke(object,args);
        System.out.println("after invoke");
        return null;
    }

    public static void main(String[] args) {
        TestInterface testInterface =new DogRun();
        InvocationHandler proxy = new DynamicProxy(testInterface);
        TestInterface proxydogRun =(TestInterface) Proxy.newProxyInstance(testInterface.getClass().getClassLoader(),testInterface.getClass().getInterfaces(),proxy);
        proxydogRun.Hello();
    }
}
