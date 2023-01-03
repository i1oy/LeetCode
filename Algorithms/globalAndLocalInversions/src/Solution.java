public class Solution {
    /**
     * 775. Global and Local Inversions
     * @param nums
     * @return
     */
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length, minSuffix = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > minSuffix) return false;
            minSuffix = Math.min(minSuffix, nums[i + 1]);
        }
        return true;
    }
}
