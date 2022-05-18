public class Solution {
    /**
     * 668. Kth Smallest Number in Multiplication Table
     * 解题思路：
     *  假设当前数值 x ，那么第 i 行中小于等于 x 的数值个数为 min(x/i, n);
     *  依次对 1-m 行中所有不超过 x 的数值个数进行求和，
     *  根据求和结果与 k 进行对比，使用二分法，调整区间范围，直至满足要求。
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int i = 1; i <= m; i++) cnt += Math.min(mid / i, n);
            if (cnt >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
