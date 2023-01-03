public class Solution {
    /**
     * 1742. Maximum Number of Balls in a Box
     * @param lowLimit
     * @param highLimit
     * @return
     */
    public int countBalls(int lowLimit, int highLimit) {
        int max = 0;
        int[] counts = new int[46];
        int current = lowLimit, sum = 0;
        while (current > 0) {
            sum += current % 10;
            current /= 10;
        }
        int i = lowLimit;
        while (i <= highLimit) {
            max = max < ++counts[sum] ? counts[sum] : max;
            int temp = i;
            while (temp % 10 == 9) {
                // 末尾为 9..9 时，加 1 进位后会被置为 0，因此当前的和需要减 9
                sum -= 9;
                temp /= 10;
            }
            sum++;
            i++;
        }
        return max;
    }
}
