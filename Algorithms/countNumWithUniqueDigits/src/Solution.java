public class Solution {
    /**
     * 解题思路：
     * 当 n = 0 时， 满足要求的数字个数 n0 是 1；
     * 当 n = 1 时， 满足要求的数字个数 n1 是 1 + 9；
     * 当 n = 2 时， 满足要求的数字个数 n1 是 1 + 9 + 9 * 9 （数字的最高位不能为 0， 因此有 9 种可能，
     *  第二位除去最高位的数字，在 0-9 中选择有 9 种可能）；
     * 依此类推，当 n > 2 时， 满足要求的数字个数是 1 + 9 + 9 * 9 + 9 * 9 * 8 + ...
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        int n0 = 1, n1 = 10;
        if (n == 0) return n0;
        if (n == 1) return n1;
        int ans = n1;
        for (int i = 2; i <= n; i++) {
            int temp = 9;
            for (int j = 1; j < i; j++) {
                temp *= (10 - j);
            }
            ans += temp;
        }
        return ans;
    }
}
