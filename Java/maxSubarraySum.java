import java.util.ArrayList;
import java.util.Arrays;

public class maxSubarraySum {
    public static void main(String[] args) {
        Integer[] a = {-2, 3, -4, -11, -2, 10, -5, -3};
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(a));
        System.out.println(findMaxIntervalImproved(arr));
        System.out.println(findMaxInterval(arr));
    }

    //    Time n^2 Space 1
        public static int findMaxInterval(ArrayList<Integer> arr){
            int maxSum = arr.get(0);
            int currentSum = maxSum;
            int intervalHead;
            int intervalTail;
            for (int i = 0; i < arr.size(); i++) {
                currentSum=0;
                for (int j = i; j < arr.size(); j++) {
                    currentSum+=arr.get(j);
                    if (currentSum>maxSum){
                        maxSum=currentSum;
                        intervalHead = i;
                        intervalTail = j;
                    }
                }
            }
            return maxSum;
        }

//      Time n space 1
        public static int findMaxIntervalImproved(ArrayList<Integer> arrayList){
            int maxSum = arrayList.get(0);
            int currentSum = maxSum;
            for (int i = 1; i < arrayList.size(); i++) {

//            方法一
                currentSum = currentSum>0 ? currentSum+arrayList.get(i) : arrayList.get(i);
//            方法二
//            if (currentSum>0){
//                currentSum+=arrayList.get(i);
//            }else {
//                currentSum = arrayList.get(i);
//            }
//            方法三
//            currentSum = Math.max(arrayList.get(i), currentSum=arrayList.get(i));
//            更新当前和 (currentSum)：对于每个元素arrayList.get(i)，算法更新currentSum。如果currentSum加上当前元素的值仍然保持正数，这意味着添加当前元素能使子数组的总和更大，因此将其加入到当前子数组中。如果currentSum加上当前元素后变成负数，或者currentSum本身就是负数，这意味着当前元素不会对增加总和产生积极作用，因此应该从当前元素开始一个新的子数组。这一步是通过三元运算符实现的：

                if (currentSum>maxSum) maxSum=currentSum;
            }
            return maxSum;
        }

//        Time n space n  using DP

        public static int FindGreatestSumOfSubArray(int[] array){
            int maxSum = Integer.MIN_VALUE;
            int[] dp = new int[array.length];
            dp[0] = array[0];
            for (int i = 1; i < array.length; i++) {
                dp[i] = Math.max(dp[i-1]+array[i], array[i]);
            }
//            读取dp可优化到上一训话，这里保留dp的理念
            for (int currentMax :
                    dp) {
                if (currentMax>maxSum)maxSum=currentMax;
            }
            return maxSum;
        }



//输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，找到一个具有最大和的连续子数组。
//1.子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
//2.如果存在多个最大和的连续子数组，那么返回其中长度最长的，该题数据保证这个最长的只存在一个
//3.该题定义的子数组的最小长度为1，不存在为空的子数组，即不存在[]是某个数组的子数组
//4.返回的数组不计入空间复杂度计算
//    Medium Time: n Space: n
    public int[] FindGreatestSumArrayOfSubArray (int[] array) {
        if (array.length == 1) return array;
        int currentMax = array[0];
        int globalMax = Integer.MIN_VALUE;
        int currentStart = 0, currentEnd = 0;
        int globalStart = 0, globalEnd = 0;
        
        for (int i = 1; i < array.length; i++) {
            if (currentMax+array[i] >= array[i]){
                currentEnd = i;
                currentMax = currentMax + array[i];
            }else {
                currentStart = i;
                currentEnd = i;
                currentMax = array[i];
            }
            
            if (currentMax>globalMax){
                globalMax = currentMax;
                globalEnd = currentEnd;
                globalStart = currentStart;
            } else if (currentMax == globalMax) {
                if (currentEnd-currentStart>globalEnd-globalStart){
                    globalEnd = currentEnd;
                    globalStart = currentStart;
                }
            }
        }
        int[] res = new int[globalEnd-globalStart+1];
        for (int i = 0; i < res.length; i++) {
            res[i] = array[globalStart];
            globalStart++;
        }
        return res;
    }



}
