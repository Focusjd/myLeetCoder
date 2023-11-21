public class jumpFloor {
//   一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
// EASY Time: O(n), Space: O(1) similar to Fibonacci
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
//    EASY Time: O(1) Space: O(1)
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


//给定一个整数数组cost，其中cost[i]  是从楼梯第 i 个台阶向上爬需要支付的费用，下标从0开始。
// 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
//你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
//请你计算并返回达到楼梯顶部的最低花费。
//[2,5,20]
//5 你将从下标为1的台阶开始，支付5 ，向上爬两个台阶，到达楼梯顶部。总花费为5
//    [1,100,1,1,1,90,1,1,80,1]
//    6 你将从下标为 0 的台阶开始。
//1.支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
//2.支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
//3.支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
//4.支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
//5.支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
//6.支付 1 ，向上爬一个台阶，到达楼梯顶部。
//总花费为 6 。
//    EASY Time: n Space: n
//    public int minCostClimbingStairs (int[] cost) {
//        if (cost.length<=1) return cost[0];
//        int[] dp = new int[cost.length+1];
//        dp[0] = dp[1] = 0;
//        for (int i = 2; i < dp.length; i++) {
//            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
//        }
//        return dp[dp.length-1];
//    }
//    Time: n Space: 1
    public int minCostClimbingStairs (int[] cost) {
        if (cost.length<=1) return cost[0];
        int first = 0;
        int second = 0;
        int minCost = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length+1; i++) {
            minCost = Math.min(first+cost[i-2], second+cost[i-1]);
            first = second;
            second = minCost;
        }
        return minCost;
    }


    public static void main(String[] args) {
        System.out.println(new jumpFloor().jumpFloor(7));
        System.out.println(new jumpFloor().jumpFloorII(3));
    }
}
