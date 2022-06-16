package LeetCode;

import java.util.ArrayList;
import java.util.List;

//求最小x近邻k个数
public class XSoundKSibling {
    //常规解法
    public static List<Integer> findClosestElements(int[] arr,int k,int x){
        int length = arr.length;
        //双指针
        List<Integer> integers = new ArrayList<>(k);
        List<Integer> distance = new ArrayList<>(k);
        //初始化距离，初始k个数据，
        for (int i = 0; i < k; i++) {
            integers.add(arr[i]);
            distance.add(Math.abs(Integer.valueOf(arr[i])-Integer.valueOf(x)));
        }
        //遍历比较得到最小距离然后替换。
        for (int i = k; i < arr.length; i++) {
            int candidateDis = Math.abs(Integer.valueOf(arr[i])-Integer.valueOf(x));
            int cursor =0;
            while(  candidateDis>distance.get(cursor)
                    || (candidateDis==distance.get(cursor)&&arr[i]>=integers.get(cursor)))
            {
                cursor= cursor+1;
                if(cursor>=distance.size()) break;
            }
            if(cursor<k){
                integers.remove(cursor);
                integers.add(arr[i]);
                distance.remove(cursor);
                distance.add(candidateDis);
            }
        }
        return integers;
    }

    //二分法
    public static List<Integer>  divideClosestElements(int[] arr,int k,int x){
        return new ArrayList<>(k);
    }

    public static void main(String[] args) {
        int[] source = {1,2,3,4,5};
        int k =4,x=3;
        List<Integer> closestElements = findClosestElements(source, k, x);
        closestElements.stream().forEach(System.out::println);
    }
}
