import java.util.ArrayList;

public class Fibonacci {
//  Time: O(n^2) Space: O(n)
//    public static int Fibonacci (int n) {
//        if (n<=1) return n;
//        return Fibonacci(n-1)+Fibonacci(n-2);
//    }

//   Time: O(n) Space: O(n)
//    public static int Fibonacci(int n){
//        int[] dp = new int[n+2];
//        dp[1] = dp[2] = 1;
//        for (int i = 3; i < n+1; i++) {
//            dp[i] = dp[i-1]+dp[i-2];
//        }
//        return dp[n];
//    }

//    Time: O(n) Space: O(1)
    public static int Fibonacci(int n){
        if (n<=1) return n;
        int first = 0;
        int second = 1;
        int res = 1;
        for (int i = 0; i < n-1; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Fibonacci.Fibonacci(4));
    }
}
