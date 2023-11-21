import java.util.HashMap;
import java.util.HashSet;

//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
//Medium Time: n Space: n
public class LongestDifSubstring {
    public int lengthOfLongestSubstring (String s) {
        if (s.isEmpty())return 0;
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> dict = new HashMap<>();
        int maxLength = 1;
        dp[0] = 1;
        dict.put(chars[0], 0);
        for (int i = 1; i < dp.length; i++) {
            if (dict.containsKey(chars[i]) && i - dict.get(chars[i])<=dp[i-1]){ //后半部分比较现有长度是否包含重复的字符
                dp[i] = i - dict.get(chars[i]);
            }else {
                dp[i] = dp[i-1]+1;
            }


            dict.put(chars[i], i);
        }

        for (int i : dp) {
            maxLength = Math.max(i, maxLength);
        }
        return maxLength;
    }
//  带添加滑动指针方法
}
