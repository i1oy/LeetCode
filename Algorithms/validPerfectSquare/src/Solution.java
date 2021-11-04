public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        int[] arrays = new int[]{808201, 16, 14, 12, 10, 9, 4, Integer.MAX_VALUE, 1};
        for (int num : arrays) {
            System.out.println(app.isPerfectSquare(num));
        }
    }

    /**
     * 原理: (n+1)^2 - n^2 = 2n + 1
     */
    public boolean isPerfectSquare(int num) {
        int a = 1;
        while (num > 0) {
            num -= a;
            a += 2;
        }
        return num == 0;
    }
}
