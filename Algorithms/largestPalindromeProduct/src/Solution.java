public class Solution {
    /**
     * 479. Largest Palindrome Product
     * 解题思路（官网题解）：
     *  枚举法。
     *  两个 n 位整数的乘积的最大值为 2n 位数；
     *  从 n 位的最大整数开始，构造 2n 位回文整数
     *  （此处不是遍历各个整数判断是否为回文数，而是以 n 位数为左半边模板，构造 2n 位的回文整数）
     *  最后判断在 [sqrt(回文整数), n 位最大整数] 区间内，是否存在整数能整除构造出的回文整数。
     * @param n
     * @return
     */
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int upper = (int) Math.pow(10, n) - 1;
        for (int left = upper; upper > 0; left--) {
            long product = left;
            for (int x = left; x > 0; x /= 10)
                product = product * 10 + x % 10;
            int psqrt = (int) Math.ceil(Math.sqrt(product));
            for (int y = upper; y >= psqrt; --y) {
                if (product % y == 0) {
                    // System.out.format("%d, %d", product, s);
                    return (int) (product % 1337);
                }
            }
        }
        return 0;
    }
}
