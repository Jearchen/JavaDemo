package com.jeartech;



//寻找需要补充粉笔的学生的编号
public class ReplaceChlker {
    public static int chalkReplacer(int[] chalk, int k) {
        int  length = chalk.length;
        int  n =length;
        long[] ansArr = new long[length];
        long  sum = 0;
        int position = 0;
        for (int i = 0; i < n; i++) {
            ansArr[i] = sum + chalk[i];
            sum = ansArr[i];
            if(sum>k){
                position = i;
            }
        }
        long remain = k % sum;

        for (int i = 0; i < ansArr.length; i++) {
            if(ansArr[i]==remain){
                position = i+1;
                break;
            }
            if(ansArr[i]>remain){
                position = i;
                break;
            }
        }
        return position;
    }
    public static void main(String[] args) {
        int[] chalkNum = {3,4,1,2};
        int k = 25;
        int position = chalkReplacer(chalkNum, k);
        System.out.println(position);
    }
}
