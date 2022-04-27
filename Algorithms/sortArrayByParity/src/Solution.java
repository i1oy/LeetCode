public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 != 0) {
                while (left < right) {
                    if (nums[right] % 2 == 0) {
                        int temp = nums[left];
                        nums[left] = nums[right];
                        nums[right] = temp;
                        --right;
                        break;
                    }
                    --right;
                }
            }
            ++left;
        }
        return nums;
    }
}
