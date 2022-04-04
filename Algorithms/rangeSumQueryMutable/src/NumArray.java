public class NumArray {

    private int[] nums;
    private int[] sum;
    private int size;

    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        size = (int) Math.sqrt(n);
        sum = new int[(n + size - 1) / size];
        for (int i = 0; i < n; i++) sum[i / size] += nums[i];
    }

    public void update(int index, int val) {
        sum[index / size] += val - nums[index];
        nums[index] = val;
    }

    /**
     * 307. Range Sum Query - Mutable #Medium
     * 解题思路：
     * 分块处理。
     * 将原数组分成若干块（参考官方题解，划分成 Math.sqrt(nums.length) 块），进行分块求和；
     * 执行 update 时，同时更新 nums[index] 和 sum[index / size]；
     * 执行 sumRange 时，先对 left 与 right 所跨越的区间求和，
     * 再扣除 startRange 到 left 这部分的数值，
     * 最后加上 endRange 到 right 这部分的数值。
     *
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        int startRange = left / size, endRange = right / size;
        if (startRange == endRange) {
            int res = 0;
            for (int i = left; i <= right; i++) res += nums[i];
            return res;
        }
        int ans = 0;
        for (int i = startRange; i < endRange; i++) ans += sum[i];
        for (int i = startRange * size; i < left; i++) ans -= nums[i];
        for (int i = endRange * size; i <= right; i++) ans += nums[i];
        return ans;
    }

    public static void main(String[] args) {
        NumArray numArr = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArr.sumRange(0, 2));
        NumArray numArray = new NumArray(new int[]{0, 9, 5, 7, 3});
        System.out.println(numArray.sumRange(2, 3));
        System.out.println(numArray.sumRange(3, 3));
        // numArray.update(1, 2);
        // System.out.println(numArray.sumRange(0, 2));
    }
}