public class jumpFloor {
// Time: O(n), Space: O(1) similar to Fibonacci
    public int jumpFloor(int number) {
        if (number<=2) return number;
        int a = 1;
        int b = 2;
        int res = 3;
        for (int i = 0; i < number - 2; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new jumpFloor().jumpFloor(7));
    }
}
