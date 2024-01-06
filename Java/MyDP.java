public class MyDP {
//    给定两个字符串str1和str2,输出两个字符串的最长公共子串
//    题目保证str1和str2的最长公共子串存在且唯一。
// Medium Time n^2 Space n^2
    public String LCS (String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLength = 0;
        int maxLengthIndex = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > maxLength){
                    maxLength = dp[i][j];
                    maxLengthIndex = i;
                }
            }
        }
        return str1.substring(maxLengthIndex - maxLength, maxLengthIndex);
    }


}
