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
    public void Insert(Integer num) {
        if (minQ.isEmpty()){
            minQ.offer(num);
            return;
        }
        if (maxQ.isEmpty()){
            if (num<=minQ.peek()){
                maxQ.offer(num);
            }else {
                maxQ.offer(minQ.poll());
                minQ.offer(num);
            }
            return;
        }

        if (num>maxQ.peek()){
            if (minQ.size() - maxQ.size() >= 1){
                maxQ.offer(minQ.poll());
            }
            minQ.offer(num);
        }else {
            if (maxQ.size() - minQ.size() >= 0){
                minQ.offer(maxQ.poll());
            }
            maxQ.offer(num);
        }
    }

    public Double GetMedian() {
        if ((minQ.size() + maxQ.size()) % 2 == 1){
            return (double) minQ.peek();
        }
        return (minQ.peek()+maxQ.peek())/2.0 ;
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
//    public int findKth (int[] a, int n, int K) {
//        quickSort(a, 0, a.length -1);
//        return a[n-K];
//    }

    public void quickSort(int[] arr, int left, int right){
        if (right <= left)
            return;

        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

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
    public int partition(int[] arr, int left, int right){
        int i = left, j = right + 1;
        while (true){
            while (arr[++i] < arr[left]){
                if (i == right)
                    break;
            }
            while (arr[--j] > arr[left]){
                if (j == left)
                    break;
            }
            if (i >= j)
                break;
            swapInArray(arr, i, j);
        }
        swapInArray(arr, left, j);
        return j;
    }
    public void swapInArray(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }



    public int findKth (int[] a, int n, int K) {
        mergeSort(a);
        return a[n-K];
    }
    public void merge(int[] arr, int[] aux, int left, int mid, int right){
        aux = Arrays.copyOfRange(arr, left, right + 1);

        for (int i = left; i <= right; i++) {
            aux[i] = arr[i];
        }
        System.arraycopy(arr, left, aux, left, right + 1 - left);


        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid)        arr[k] = aux[j++];
            else if (j > right) arr[k] = aux[i++];
            else if (aux[i] < aux[j]) arr[k] = aux[i++];
            else                arr[k] = aux[j++];
        }
    }

    public void sort(int[] arr, int[] aux, int left, int right){
        if (right <= left) return;
        int mid = (left + right) / 2;
        sort(arr, aux, left, mid);
        sort(arr, aux, mid + 1, right);
        merge(arr, aux, left, mid, right);
    }

    public void mergeSort(int[] arr){
        int[] aux = new int[arr.length];
        sort(arr, aux, 0, arr.length -1);
    }











}


