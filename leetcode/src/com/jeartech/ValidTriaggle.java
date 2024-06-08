package com.jeartech;


import java.util.Arrays;

//查询有效的三角形个数
public class ValidTriaggle {
    //法一：暴力破解
    public static int triangleNumber (int[] nums){
        int[] agreeCompose = new int[3];
        int arrLen = nums.length;
        int count = 0;
        for(int i =0;i<arrLen;i++)
        {
            for(int j=i+1;j<arrLen;j++)
            {
                for(int k=j+1;k<arrLen;k++)
                {
                    if((nums[i]+nums[j])>nums[k]
                            &&(nums[i]+nums[k])>nums[j]
                            &&(nums[j]+nums[k])>nums[i]
                            &&(nums[i]-nums[j])<nums[k]
                            &&(nums[i]-nums[k])<nums[j]
                            &&(nums[j]-nums[k])<nums[i]
                    ){
                        count+=1;
//                        System.out.println("triAngle:"+String.valueOf(nums[i])+String.valueOf(nums[j])+String.valueOf(nums[k]));
                    }
                }
            }
        }
        return count;
    }
    /**
     * 法二：尝试性解题.
     * 耗时:2022-6-15到2022-6-16
     */
    public static int triangleNumber1 (int[] nums){
        int length = nums.length;
        int count = 0;
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        Arrays.stream(sorted).forEach(System.out::print);
        int i =length-1;
        while(i>=2)
        {
            int cursor1 = 0;
            int cursor2 = i-1;
            int mid = (cursor2+cursor1)/2;
            while(cursor2>=1)
            {
                int sum = sorted[mid] + sorted[cursor2];
                if(cursor1>=cursor2){
                    break;
                }
                if(sum>=sorted[i]){
                    count = count + MathUtil.Cnm(cursor2-mid+1,2);
//                    System.out.println("area:["+sorted[mid]+"-"+sorted[cursor2]+"]"+"&"+sorted[i]);
                    cursor2 = mid-1;
                }else{
                    cursor1 = mid+1;
                }
                mid  = (cursor2+cursor1)/2;
            }
            i = i -1;
        }
        return count;
    }





    
    public static void main(String[] args) {
        int[] nums = {4,2,3,9,7,6};
//        int[] nums = {2,2,3,4};
        int cnm = triangleNumber1(nums);
        System.out.println(cnm);
        int cnm1 = triangleNumber(nums);
        System.out.println(cnm1);
//        int cnm1 = Cnm(12, 5);
//        System.out.println(cnm1);
    }
}
