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


}
