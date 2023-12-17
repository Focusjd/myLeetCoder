import java.util.*;

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


//    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
//[[1,2,3,4],
//[5,6,7,8],
//[9,10,11,12],
//[13,14,15,16]]
//[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        while (left <= right && up <= down){
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (up <= down){
                for (int i = right; i >= left ; i--) {
                    res.add(matrix[down][i]);
                }
            }
            down--;

            if (left <= right){
                for (int i = down; i >= up; i--){
                    res.add(matrix[i][left]);
                }
            }
            left++;

        }
        return res;
    }

//    给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。
//    例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。

    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k < 1) {
            return res;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.reverseOrder());

        for (int num:
             input) {
            if (pq.size() < k){
                pq.offer(num);
            }else {
                if (num < pq.peek()){
                    pq.poll();
                    pq.offer(num);
                }
            }
        }

        res.addAll(pq);
        return res;
    }


}


