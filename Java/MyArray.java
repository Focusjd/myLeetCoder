import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MyArray {
//    给出一个有序的整数数组 A 和有序的整数数组 B ，请将数组 B 合并到数组 A 中，变成一个有序的升序数组
//    !!!!!!
//    public void merge(int A[], int m, int B[], int n) {
//        int a = m -1;
//        int b = n -1;
//
//        for (int i = 0; i < m + n; i++) {
//            int currMax;
//
//            if (a >=0 && b >=0){
//                if (A[a] > B[b]){
//                    currMax = A[a];
//                    a--;
//                }else {
//                    currMax = B[b];
//                    b--;
//                }
//            }else {
//                currMax = a >= 0 ? A[a] : B[b];
//            }
//
//            A[m+n-1-i] = currMax;
//        }
//    }


    public int MoreThanHalfNum_Solution (int[] numbers) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num :
                numbers) {
            if (hashMap.containsKey(num)){
                hashMap.put(num, hashMap.get(num)+1);
            }else {
                hashMap.put(num, 1);
            }
            if (hashMap.get(num) > numbers.length/2)
                return num;
        }
        return 0;
    }


//    在有序数组中找出两个数，使得和为给定的数 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (array[left] + array[right] == sum){
                res.add(array[left]);
                res.add(array[right]);
                break;
            } else if (array[left] + array[right] < sum) {
                left++;

            }else {
                right--;
            }
        }
        return res;
    }




}


