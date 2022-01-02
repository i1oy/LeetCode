public class Solution {
    // 390. Elimination Game
    public static void main(String[] args) {
        Solution app = new Solution();
        int[] cases = new int[]{1, 2, 9, (int) Math.pow(10, 9)};
        for (int num : cases) {
            System.out.println(app.lastRemaining(num));
        }
    }

    public int lastRemaining(int n) {
        int head = 1, step = 1, count = n;
        boolean left = true;
        while (count > 1) {
            if (left || count % 2 == 1) head = head + step;
            left = !left;
            count >>= 1;
            step <<= 1;
        }
        return head;
    }
}
