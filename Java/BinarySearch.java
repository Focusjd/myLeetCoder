import java.rmi.dgc.VMID;
import java.util.Arrays;

public class BinarySearch {

//请实现无重复数字的升序数组的二分查找
//    Easy Time logn Space 1
    public int search (int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int mid = (left + right)/2;

            if (target == nums[mid])
                return mid;

            if (nums[mid] < target){
                left = mid +1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }

//    递归方法
//    public int biSearch (int[] nums, int target) {
//        if (nums.length == 0) {
//            return -1;
//        }
//
//        int left = 0;
//        int right = nums.length -1;
//
//        return biSearchHelper(nums, target, left, right);
//    }
//
//    public int biSearchHelper(int[] nums, int target, int left, int right){
//
//        int mid = (left + right)/2;
//        if (nums[mid] == target)
//            return mid;
//
//        if (left > right)
//            return -1;
//
//        return target < nums[mid] ? biSearchHelper(nums, target, left, mid -1) : biSearchHelper(nums, target, mid +1, right);
//    }


//    在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//            [
//            [1,2,8,9],
//            [2,4,9,12],
//            [4,7,10,13],
//            [6,8,11,15]
//            ]
//    给定 target = 7，返回 true。
//
//    给定 target = 3，返回 false。
//    Medium Time m+n Space 1
    public boolean Find (int target, int[][] array) {
        int height = array.length;
        int width = array[0].length;
        int h = height -1;
        int w = 0;
        for (int i = 0; i < height + width; i++) {
            if (h < 0 || w > width -1)
                break;
            if (target == array[h][w])
                return true;
            if (target > array[h][w]){
                w++;
            }else {
                h--;
            }
        }
        return false;
    }

//    给定一个长度为n的数组nums，请你找到峰值并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个所在位置即可。要求logn时间
//    Medium Time n Space 1
//    public int findPeakElement (int[] nums) {
//        int index = 0;
//        if (nums.length < 2)
//            return index;
//        if (nums.length == 2)
//            index = nums[0]>nums[1]? 0 : 1;
//        if (nums[nums.length-1]> nums[nums.length-2])
//            index = nums.length-1;
//        for (int i = 1; i < nums.length - 2; i++) {
//            if (nums[i] > nums[i-1] && nums[i] < nums[i+1])
//                index = i;
//        }
//        return index;
//    }
//    Time logn Space 1
    public int findPeakElement (int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left != right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }

//有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，
// 比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。请问，给定这样一个旋转数组，求数组中的最小值。
//    Easy Time logn Space 1
    public int minNumberInRotateArray (int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]){
                right = mid;
            } else if (nums[mid] == nums[right]) {
                right --;
            } else {
                left = mid +1;
            }
        }
        return nums[left];
    }


//牛客项目发布项目版本时会有版本号，比如1.02.11，2.14.4等等
//现在给你2个版本号version1和version2，请你比较他们的大小
    public int compare (String version1, String version2) {
        String[] V1 = version1.split("\\.");
        String[] V2 = version2.split("\\.");

        int minLength = Math.min(V1.length, V2.length);

        for (int i = 0; i <minLength; i++) {
            if (Integer.parseInt(V1[i]) > Integer.parseInt(V2[i])){
                return 1;
            }else if (Integer.parseInt(V1[i]) < Integer.parseInt(V2[i])){
                return -1;
            }
        }

        if (V1.length > V2.length){
            for (int i = minLength; i < V1.length; i++) {
                if (Integer.parseInt(V1[i]) > 0)
                    return 1;
            }
        } else if (V1.length < V2.length) {
            for (int i = minLength; i < V2.length; i++) {
                if (Integer.parseInt(V2[i]) > 0)
                    return -1;
            }
        }
        return 0;
    }

//    在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
//    并将P对1000000007取模的结果输出。 即输出P mod 1000000007
    public int InversePairs (int[] nums) {
        int P = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[i])
                    P++;
            }
        }
        return P % 1000000007;
    }



}
