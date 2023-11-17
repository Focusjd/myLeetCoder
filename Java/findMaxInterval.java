import java.util.ArrayList;
import java.util.Arrays;

public class findMaxInterval {
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

    public static void main(String[] args) {
        Integer[] a = {-2, 3, -4, -11, -2, 10, -5, -3};
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(a));
        System.out.println(findMaxIntervalImproved(arr));
        System.out.println(findMaxInterval(arr));
    }
}
