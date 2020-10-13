import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{
                0, 0, 0
        };

        Solution app = new Solution();
        for (List<Integer> list : app.threeSum(nums)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int len = nums.length;
        int index = 0;
        while (index < len - 2) {
            int left = index + 1, right = len - 1;
            while (left < right) {
                int sum = nums[index] + nums[left] + nums[right];
                if (sum < 0) {
                    ++left;
                } else if (sum > 0) {
                    --right;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[index]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    while (left + 1 < len && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    while (right - 1 >= 0 && nums[right] == nums[right - 1]) {
                        --right;
                    }
                    ++left;
                    --right;
                }
            }
            while (index + 1 < len && nums[index] == nums[index + 1]) {
                ++index;
            }
            ++index;
        }
        return ans;
    }
}

