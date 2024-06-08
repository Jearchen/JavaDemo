package com.jeartech;

public class MathUtil {

    /**
     * 计算给定数值阶乘
     * @param n
     * @return
     */
    public static int factoryN(int n){
        int result = 1;
        for (int i = n; i >0; i--) {
            result = result*i;
        }
        return  result;
    }

    /**
     * 计算给定组合数的Cn,m
     * @param n
     * @param m
     * @return
     */
    public static int Cnm(int n,int m){
        return factoryN(n) / (factoryN(m)*factoryN(n-m));
    }
}
