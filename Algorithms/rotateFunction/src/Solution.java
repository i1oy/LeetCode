public class Solution {
    /**
     * 396. Rotate Function
     * 解题思路：
     * F(i) 和 F(i+1) 的关系，通过推导可以得到：
     *      F(i) =  0 * A[i] + 1 * A[i + 1] + ... + (n - 1) * A[(n - 1 + i) % n]
     *      F(i+1) = 0 * A[i + 1] + 1 * A[i + 2] + ... + (n - 1) * A[(n - 1 + (i + 1)) % n]
     *      其中， i 的最大值为 n - 1， 因此 (n - 1 + i) % n 可以直接用 (n - 1 + i) - n 替换，
     *      (n - 1 + (i + 1)) % n = (n - 1 + (i + 1)) -  n = i；
     *      F(i+1) - F(i) = -1 * (A[i+1] + A[i+2] + ... + A[n-1+i]) + (n-1) * A[i]
     *                    = -1 * (A[i] + A[i+1] + ... + A[n-1+i]) + n * A[i]
     *                    = -SUM + (n * A[i])
     * @param nums
     * @return
     */
    public int maxRotateFunction(int[] nums) {
        int ans = 0, sum = 0, len = nums.length;
        if (len == 1) return 0;
        for (int i = 0; i < len; i++) {
            ans += i * nums[i];
            sum += nums[i];
        }
        int current = ans;
        for (int i = 0; i < len; i++) {
            current = current - sum + nums[i] * len;
            ans = ans > current ? ans : current;
        }
        return ans;
    }
}
