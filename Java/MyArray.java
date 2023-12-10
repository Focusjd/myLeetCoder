public class MyArray {
//    给出一个有序的整数数组 A 和有序的整数数组 B ，请将数组 B 合并到数组 A 中，变成一个有序的升序数组
    public void merge(int A[], int m, int B[], int n) {

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (A[index] > B[i]){
                rebuildArray(B[i], index, A, m + index + 1);
            }
        }
    }

    public void rebuildArray(int target, int index, int[] arr, int m){
        for (int i = m; i > index + 1; i--){
            arr[i] = arr[i - 1];
        }
        arr[index] = target;
    }








}


