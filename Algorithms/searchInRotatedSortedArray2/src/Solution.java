public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();

        int[] nums = {
                2, 5, 6, 0, 0, 1, 2
        };
        int target = 2;
        System.out.println(app.search(nums, target));

        int[] nums2 = {
                5, 1, 3
        };
        int target2 = 3;
        System.out.println(app.search(nums2, target2));
    }

    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[left]) {
                ++left;
            } else if (nums[left] < nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (nums[right] >= target && nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return target == nums[left];
    }
}
