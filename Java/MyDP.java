public class MyDP {
//    给定两个字符串str1和str2,输出两个字符串的最长公共子串
//    题目保证str1和str2的最长公共子串存在且唯一。
//    public String LCS (String str1, String str2) {
//        int[] dp = new int[str1.length()];
//        int maxLength = 0;
//        int maxLengthIndex = 0;
//        dp[0] = str1.charAt(0) == str2.charAt(0) ? 1 :0;
//        for (int i = 1; i < str1.length(); i++) {
//            if (str1.charAt(i) == str2.charAt(i)){
//                dp[i] = dp[i-1] + 1;
//            }else {
//                dp[i] = 0;
//            }
//        }
//
//        for (int i = 0; i < dp.length; i++) {
//            if (maxLength < dp[i]){
//                maxLength = dp[i];
//                maxLengthIndex = i;
//            }
//        }
//        return str1.substring(maxLengthIndex - maxLength, maxLength);
//    }
}
