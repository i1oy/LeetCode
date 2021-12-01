public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.findNthDigit(Integer.MAX_VALUE));    // 2
        System.out.println(app.findNthDigit(10));   // 1
        System.out.println(app.findNthDigit(99));   // 4
        System.out.println(app.findNthDigit(11));   // 0
    }

    public int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= (d++) * count;
            count *= 10;
        }
        int num = (int) (Math.pow(10, d - 1) + (n - 1) / d);
        return String.valueOf(num).charAt((n - 1) % d) - '0';
    }

}
