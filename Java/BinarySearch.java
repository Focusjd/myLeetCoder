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


}
