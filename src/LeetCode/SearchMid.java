package LeetCode;

/**
 * 查找两数中位数
 */
public class SearchMid {
    public static double findMedianSortedArrays(int[] nums1,int[] nums2){
        //1、合并数组
        int step1_length = nums1.length;
        int step2_length = nums2.length;
        int[] result = new int[step1_length+step2_length];
        int cursor1 = 0, cursor2 = 0;
        for (int i = 0; i < result.length; i++) {

            if(cursor1<step1_length&&cursor2<step2_length&&nums1[cursor1]>nums2[cursor2]){
                result[i] = nums2[cursor2];
                cursor2++;
            }else if(cursor1<step1_length&&cursor2<step2_length&&nums1[cursor1]<nums2[cursor2]){
                result[i] = nums1[cursor1];
                cursor1++;
            }else if(cursor1<step1_length){
                result[i] = nums1[cursor1];
                cursor1++;
            }else{
                result[i] = nums2[cursor2];
                cursor2++;
            }
        }
        //2、查找中位数
        int mergeLength = result.length;
        if(mergeLength%2==0)
        {
            double left = (double)result[mergeLength/2];
            double right = (double)result[(mergeLength-1)/2];
            return (left+right)/2;
        }
        else{
            return (double)result[mergeLength/2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2,6};
        int[] nums2 = {9,10};
        double result = SearchMid.findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }
}
