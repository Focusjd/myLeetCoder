import java.util.HashMap;
import java.util.HashSet;

public class DuplicateElements {
//    在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
//    请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。存在不合法的输入的话输出-1
//    Easy Time n Space n
//    public int duplicate(int[] numbers) {
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int number :
//                numbers) {
//            if (!hashSet.add(number)) return number;
//        }
//        return -1;
//    }
//Time n Space 1
    public int duplicate(int[] numbers) {
        int temp = -1;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == i) continue;
            temp = numbers[numbers[i]];
            if (temp == numbers[i]) return numbers[i];
            numbers[numbers[i]] = numbers[i];
            numbers[i] = temp;
        }
        return -1;
    }




//    在一个长为 字符串中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
//Easy Time n Space n
    public int FirstNotRepeatingChar (String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!hashMap.containsKey(str.charAt(i))){
                hashMap.put(str.charAt(i), 1);
            }else {
                hashMap.put(str.charAt(i), hashMap.get(str.charAt(i))+1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.get(str.charAt(i))==1)
                return i;
        }
        return -1;
    }

}
