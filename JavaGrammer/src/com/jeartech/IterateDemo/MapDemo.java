package com.jeartech.IterateDemo;

import java.util.*;

/**
 * @author :jearchen
 * @date :2019.06.05
 */
public class MapDemo {
    public  static Map<String,String> initialmap(){
        Map<String,String> mymap = new HashMap<String, String>();

        mymap.put("1","李杰");
        mymap.put("2","熊志敏");
        return mymap;
    }
    public static void main1(String[] args) {
        /***********************初始化***************************/
        Map<String,String> newmap = initialmap();

        /***********************访问***************************/
        /**
         * 简单打印值
         */
        System.out.println(newmap.get("1"));

        /***********************遍历***************************/
            /**
             * 增强型for循环：keySet
             */
            for(String cursor:newmap.keySet())
            {
                System.out.println(cursor+":"+newmap.get(cursor));
            }
            /**
             *使用entryset
             */
            for(Map.Entry<String,String> entry :newmap.entrySet())
            {
                System.out.println(entry.getKey()+":"+entry.getValue());
            }
        /***********************迭代***************************/

        /**
         * KeySet迭代
         */
        Iterator <String> iterator =newmap.keySet().iterator();

        while(iterator.hasNext())
        {
            String key =iterator.next();
            System.out.println(key+":"+newmap.get(key));
        }
        /**
         * entrySet迭代
         */
        Iterator<Map.Entry<String,String>> iterator1 =newmap.entrySet().iterator();
        while (iterator1.hasNext())
        {
            Map.Entry<String,String> entry =iterator1.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        /***********************排序***************************/
        /**
         * HashMap、Hashtable、LinkedHashMap的排序方法
         */
        System.out.println("HashMap排序开始！");
        List<Map.Entry<String,String>> list =new ArrayList<Map.Entry<String, String>>(newmap.entrySet());
        //ArrayList构造函数将newmap.entrySet转换成list
        //通过比较器进行排序。
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        //打印排序结果
        for(Map.Entry<String,String> entry :list)
        {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        /**
         * TreeMap排序方法（默认按照升序排序，修改需要通过比较器）
         *
         */
        System.out.println("TreeSet排序开始！");
        Map<String,String> treeMap = new TreeMap<String, String>();
        treeMap.put("1","崔家俊");
        treeMap.put("3","赵坤坤");
        treeMap.put("4","沈奕谦");
        treeMap.put("2","吕陈晨");

        for(String key:treeMap.keySet())
        {
            System.out.println(key + ":" + treeMap.get(key));
        }
        /**
         * 按照value开始排序
         *
         */
        System.out.println("按值排序后结果！");
        Map<String,String> treemap2 =new TreeMap<String, String>();
        treemap2.put("3","赵坤坤");
        treemap2.put("2","吕陈晨");
        treemap2.put("4","沈奕谦");
        treemap2.put("1","崔家俊");
        List<Map.Entry<String,String>> list1 = new ArrayList<Map.Entry<String,String>>(treemap2.entrySet());

        Collections.sort(list1, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        /**
         * 显示一下treeMap元素。
         */
        for(String key :treemap2.keySet())
        {
            System.out.println(key + ":" + treemap2.get(key));
        }
        /**
         * 常用方法：entrySet()返回 Map 中所包含映射的 Set 视图。Set 中的每个元素都是一个 Map.Entry 对象，可以使用 getKey() 和 getValue() 方法（还有一个 setValue() 方法）访问后者的键元素和值元素
         * keySet()返回 Map 中所包含键的 Set 视图。删除 Set 中的元素还将删除 Map 中相应的映射（键和值）
         *values()	返回 map 中所包含值的 Collection 视图。删除 Collection 中的元素还将删除 Map 中相应的映射（键和值）
         * 上述排序优缺点总结：
         * 增强for循环使用方便，但性能较差，不适合处理超大量级的数据。
         *
         * 迭代器的遍历速度要比增强for循环快很多，是增强for循环的2倍左右。
         *
         * 使用entrySet遍历的速度要比keySet快很多，是keySet的1.5倍左右。
         */
    }
}
