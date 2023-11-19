public class jumpFloor {
//   一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
// Time: O(n), Space: O(1) similar to Fibonacci
    public int jumpFloor(int number) {
        if (number<=2) return number;
        int a = 1;
        int b = 2;
        int res = 3;
        for (int i = 0; i < number - 2; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

//    一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
//    Time: O(1) Space: O(1)
//    public int jumpFloorII (int number) {
//        return (int) Math.pow(2,  number-1);
//    }
//    Time: O(n) Space:P(n)
    public int jumpFloorII (int number) {
        int[] dp = new int[number+1];
        dp[1] = 1;
        for (int i = 2; i < number+1; i++) {
            dp[i]=2 * dp[i-1];
        }
        return dp[number];
    }


    public static void main(String[] args) {
        System.out.println(new jumpFloor().jumpFloor(7));
        System.out.println(new jumpFloor().jumpFloorII(3));
    }
}
