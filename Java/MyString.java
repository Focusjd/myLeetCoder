import java.util.Arrays;

public class MyString {

//    给定一个长度为 n 的字符串，请编写一个函数判断该字符串是否回文。如果是回文请返回true，否则返回false。
    public boolean isPa(String input){
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i -1)) // length - i -1
                return false;
        }
        return true;
    }

//    翻转String
    public String reverseString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(str.length() -i -1));
        }
        return sb.toString();
    }

//    请实现一个函数，将一个字符串s中的每个空格替换成“%20”。
//例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
//    Easy Time n Space n
//    public String replaceSpace (String s) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            char curr = s.charAt(i);
//            sb.append(curr == ' ' ? "%20" : curr);
//        }
//        return sb.toString();
//    }
// Time n Space 1
    public String replaceSpace (String s) {
        StringBuilder sb = new StringBuilder(s);
        int length = sb.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ')
                sb.append("  ");
        }
        int offset = sb.length() -1;

        for (int i = 0; i < length; i++) {
            char curr = sb.charAt(length - 1 - i);
            if (curr == ' '){
                sb.setCharAt(offset--, '0');
                sb.setCharAt(offset--, '2');
                sb.setCharAt(offset--, '%');
            }else {
                sb.setCharAt(offset--, curr);
            }
        }
        return sb.toString();
    }



//翻转单词序列
// 输入：
//"nowcoder. a am I"
//返回值：
//"I am a nowcoder."
//    Easy Time n Space n
//    public String ReverseSentence(String str) {
//        String[] wordsList = str.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < wordsList.length; i++) {
//            sb.append(wordsList[wordsList.length-1-i]);
//            sb.append(" ");
//        }
//        return sb.toString().trim();
//    }


//    Time n Space 1
//    public static String ReverseSentence(String str) {
//        char[] chars = str.toCharArray();
//        for (int i = 0; i < chars.length / 2; i++) {
//            char temp = chars[i];
//            chars[i] = chars[chars.length - 1 - i];
//            chars[chars.length - 1 -i] = temp;
//        }
//
//        int fast = 0;
//        int slow = 0;
//        for (int i = 0; i <= chars.length; i++) {
//            if (i == chars.length || chars[i] == ' '){
//                fast = i;
//                for (int j = 0; j < (fast - slow) / 2; j++) {
//                    char temp = chars[slow+j];
//                    chars[slow+j] = chars[fast -1 -j];
//                    chars[fast -1 -j] = temp;
//                }
//                slow = fast + 1;
//            }
//        }
//        return String.valueOf(chars);
//    }
//    Time n Space 1
    public static String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverseCharArray(chars, 0, chars.length-1);
        int fast, slow =0;
        for (int i = 0; i < chars.length + 1; i++) {
            if (i == chars.length || chars[i] == ' '){
                fast = i;
                reverseCharArray(chars, slow, fast - 1);
                slow = fast + 1;
            }
        }
        return String.valueOf(chars);
    }

    public static void reverseCharArray(char[] chars, int start, int end){
        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }




    public static void main(String[] args) {
        System.out.println(ReverseSentence("This is a sample"));
    }

}
