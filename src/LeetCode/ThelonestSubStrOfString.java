package LeetCode;

public class ThelonestSubStrOfString {
    static boolean judgeInside(String s, char c) {
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == c) {
                return true;
            }
        }
        return false;
    }

    static int lengthOfLongestSubstring(String s) {
//            int[] last = new int[128];
//            for(int i = 0; i < 128; i++) {
//                last[i] = -1;
//            }
//            int n = s.length();
//
//            int res = 0;
//            int start = 0; // 窗口开始位置
//            for(int i = 0; i < n; i++) {
//                int index = s.charAt(i);
//                start = Math.max(start, last[index] + 1);
//                res   = Math.max(res, i - start + 1);
//                last[index] = i;
//            }
//            return res;


        int res = 0;
        if (s.equals("")) {
            return res;
        }
        if (s.equals(" ")) {
            return 1;
        }
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((j - i) == 1) {
                    if( s.charAt(i) == s.charAt(j))
                    {
                        res = Math.max(res, 1);
                        break;
                    }
                    res =Math.max(res,2);
                    continue;
                } else if (s.substring(i, j).contains(String.valueOf(s.charAt(j)))) {
                    System.out.println(s.substring(i, j));
                    res = Math.max(res, (j - i)+1);
                    break;
                }
            }
        }
        return res;


    }

    public static void main(String[] args) {
//            String str ="abcdedabcde";
//            String str ="bbbb";
        String str = "abcabcd";
        int str1 = ThelonestSubStrOfString.lengthOfLongestSubstring(str);
        System.out.println(str1);
    }
}
