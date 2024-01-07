import java.security.Key;
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
        int right = array.length-1;
        while (left<right){
            if (array[left] + array[right] == sum){
                res.add(array[left]);
                res.add(array[right]);
                break;
            } else if (array[left] + array[right] > sum) {
                right --;
            }else {
                left ++;
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
    public ArrayList<Integer> spiralOrder (int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true){
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom)
                break;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (right < left)
                break;

            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (bottom < top)
                break;

            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right)
                break;
        }

        return res;
    }

//    给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。
//    例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
// medium Time nlogk Space k
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

//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值
// 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
// 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
// Medium Insert Time nlogn Space n bug exist!!!!!
    PriorityQueue<Integer> minQ = new PriorityQueue<>();
    PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());

    public boolean isOdd(){
        return (maxQ.size()+minQ.size()) % 2 == 1;
    }

    public boolean isBalanced(){
        return minQ.size() - maxQ.size() >= 0 && minQ.size() - maxQ.size() <= 1;
    }
    public void balance(){
        if (!(minQ.size() - maxQ.size() >= 0)){
            minQ.offer(maxQ.poll());
            return;
        }
        if (!(minQ.size() - maxQ.size() <= 1)){
            maxQ.offer(minQ.poll());
            return;
        }
    }
    public void Insert(Integer num) {
        if (minQ.isEmpty()){
            minQ.offer(num);
            return;
        }
        if (num > minQ.peek()){
            minQ.offer(num);
        }else {
            maxQ.offer(num);
        }
        if (!isBalanced())
            balance();
    }

    public Double GetMedian() {
        if (isOdd())
            return (double) minQ.peek();
        return (minQ.peek() + maxQ.peek()) / 2.0;
    }

//给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
//例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
// 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
//窗口大于数组长度或窗口长度为0的时候，返回空。
//    !!!!!!!!!!!!!!
    public ArrayList<Integer> maxInWindows (int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size > num.length || size == 0)
            return res;
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(size, Comparator.reverseOrder());
        for (int i = 0; i < size; i++) {
            queue.offer(num[i]);
            pq.offer(num[i]);
        }
        res.add(pq.peek());
        for (int i = size; i < num.length; i++) {
            int removed = queue.poll();
            pq.remove(removed); // need optimization
            queue.add(num[i]);
            pq.offer(num[i]);
            res.add(pq.peek());
        }
        return res;
    }

//    给定一个长度为 n 的非降序数组和一个非负数整数 k ，要求统计 k 在数组中出现的次数

    public int GetNumberOfK (int[] nums, int k) {
        int start = findInArray(nums, k - 0.5);
        int end = findInArray(nums, k + 0.5);
        return end - start;
    }

    public int findInArray(int[] nums, double target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return left;
    }

//有一个整数数组，请你根据快速排序的思路，找出数组中第 k 大的数。
//给定一个整数数组 a ,同时给定它的大小n和要找的 k ，请返回第 k 大的数(包括重复的元素，不用去重)，保证答案存在。
//    Quick Select
    public int findKth(int[] a, int n, int K) {
        int index = quickSelect(a, 0, a.length - 1, K);
        return a[index];
    }
    public int quickSelect(int[] arr, int left, int right, int K){
        int pivot = partition(arr, left, right);
        int Kth = arr.length - K;
        if (pivot > Kth){
            return quickSelect(arr, left, pivot - 1, K);
        } else if (pivot < Kth) {
            return quickSelect(arr, pivot + 1, right, K);
        }
        return pivot;
    }

    private int partition(int[] arr, int left, int right) {
        int last = left;
        for (int i = left; i <= right; i++) {
            if (arr[i] < arr[left])
                swap(arr, i, ++last);
        }
        swap(arr, left, last);
        return last;
    }


    //public int findKth(int[] a, int n, int K) {
//    int index = partition(a, 0, n - 1, K);
//    return a[index];
//}
//    private int partition(int[] arr, int left, int right, int K) {
//        int i = left, j = right + 1;
//        while (true){
//            while (arr[++i] < arr[left]){
//                if (i == right) break;  // 注意一定是等号 == 不是 >
//            }
//            while (arr[--j] > arr[left]){
//                if (j == left) break;
//            }
//            if (i >= j)
//                break;
//            swap(arr, i, j);
//        }
//        swap(arr, left, j);
//
//        if (j > arr.length - K){
//            return partition(arr, left, j - 1, K);
//        } else if (j < arr.length - K) {
//            return partition(arr, j + 1, right, K);
//        }
//        return j;
//    }
//
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    Quick Sort
//    public int findKth (int[] a, int n, int K) {
//        quickSort(a, 0, a.length -1);
//        return a[n-K];
//    }
//    public void quickSort(int[] arr, int left, int right){
//        if (right <= left)
//            return;
//
//        int p = partition(arr, left, right);
//        quickSort(arr, left, p - 1);
//        quickSort(arr, p + 1, right);
//    }

//    public int partition(int[] arr, int left, int right){
//        int mid = (left + right) / 2;
//        swapInArray(arr, mid, left);
//        int last = left;
//        for (int i = left + 1; i <= right; i++) {
//            if (arr[i] < arr[left])
//                swapInArray(arr, ++last, i);
//        }
//        swapInArray(arr, last, left);
//        return last;
//    }
//    public int partition(int[] arr, int left, int right){
//        int i = left, j = right + 1;
//        while (true){
//            while (arr[++i] < arr[left]){
//                if (i == right)
//                    break;
//            }
//            while (arr[--j] > arr[left]){
//                if (j == left)
//                    break;
//            }
//            if (i >= j)
//                break;
//            swapInArray(arr, i, j);
//        }
//        swapInArray(arr, left, j);
//        return j;
//    }
//    public void swapInArray(int[] arr, int a, int b){
//        int temp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
//    }


//    Merge Sort
//    public int findKth (int[] a, int n, int K) {
//        mergeSort(a);
//        return a[n-K];
//    }
    public void mergeSort(int[] arr){
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length -1);
    }

    public void mergeSort(int[] arr, int[] aux, int left, int right){
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, aux, left, mid);
        mergeSort(arr, aux, mid + 1, right);
        merge(arr, aux, left, mid, right);
    }
//    public void mergeSort(int[] arr){
//        int n = arr.length;
//        int[] aux = new int[n];
//
//        for (int len = 1; len < n; len*=2) {
//            for (int lo = 0; lo < n - len; lo += len + len) {
//                int mid = lo + len - 1;
//                int hi = Math.min(lo + len + len - 1, n - 1);
//                merge(arr, aux, lo, mid, hi);
//            }
//        }
//    }
//
    public void merge(int[] arr, int[] aux, int left, int mid, int right){
        for (int i = left; i <= right; i++) {
            aux[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid)
                arr[k] = aux[j++];
            else if (j > right) {
                arr[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                arr[k] = aux[j++];
            }else {
                arr[k] = aux[i++];
            }
        }
    }

//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//    Easy Time n
    public int[] printNumbers (int n) {
        int upper = (int) Math.pow(10, n) -1;
        int[] res = new int[upper];
        for (int i = 1; i <= upper; i++) {
            res[i-1] = i;
        }
        return res;
    }

//现在有2副扑克牌，从扑克牌中随机五张扑克牌，我们需要来判断一下是不是顺子。
//有如下规则：
//1. A为1，J为11，Q为12，K为13，A不能视为14
//2. 大、小王为 0，0可以看作任意牌
//3. 如果给出的五张牌能组成顺子（即这五张牌是连续的）就输出true，否则就输出false。
//4.数据保证每组5个数字，每组最多含有4个零，数组的数取值为 [0, 13]
//    Easy Time n Space n
    public boolean IsContinuous (int[] numbers) {
        int zeroNum = 0;
        int maxNum = -1;
        int minNum = 14;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num :
                numbers) {
            if (num == 0){
                zeroNum ++;
                continue;
            }
            if (hashSet.contains(num)){
                return false;
            }else {
                hashSet.add(num);
            }
            if (num < minNum)
                minNum = num;
            if (num > maxNum)
                maxNum = num;
        }
        return maxNum - minNum - 1 - zeroNum - (3 - zeroNum) <= 0;
    }

//    给定一个数组 A[0,1,...,n-1] ,请构建一个数组 B[0,1,...,n-1] ,
//    其中 B 的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]（除 A[i] 以外的全部元素的的乘积）。
//    程序中不能使用除法。（注意：规定 B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2]）
//对于 A 长度为 1 的情况，B 无意义，故而无法构建，用例中不包括这种情况。
//    EASY Time n Space 1
    public int[] multiply (int[] A) {
        int[] res = new int[A.length];
        res[0] = 1;
        for (int i = 1; i < A.length; i++) {
            res[i] = res[i - 1] * A[i - 1];
        }
        int temp = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            res[i] *= temp;
            temp *= A[i];
        }
        return res;
    }
//    Time n^2 Space 1
    // public int[] multiply (int[] A) {
    //     int[] res = new int[A.length];
    //     for (int i = 0; i < A.length; i++) {
    //         res[i] = 1;
    //         for (int j = 0; j < A.length; j++) {
    //             if (i == j)
    //                 continue;
    //             res[i]*=A[j];
    //         }
    //     }
    //     return res;
    // }

//输入一个长度为 n 整数数组，数组里面可能含有相同的元素，实现一个函数来调整该数组中数字的顺序，
// 使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，对奇数和奇数，偶数和偶数之间的相对位置不做要求
    public int[] reOrderArrayTwo (int[] array) {
        if (array.length == 0) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && isOdd(array[left]))
                left++;
            while (left < right && !isOdd(array[right]))
                right--;

            swap(array, left, right);
        }

        return array;
    }
    public boolean isOdd(int num){
        return num % 2 == 1;
    }


}


