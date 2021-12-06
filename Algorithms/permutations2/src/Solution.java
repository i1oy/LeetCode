import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        app.permuteUnique(new int[]{1, 2, 3});
        app.permuteUnique(new int[]{1, 1, 3});
    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new int[nums.length], 0);
        return ans;
    }

    private void backtrack(int[] nums, int[] temp, int index) {
        int len = nums.length;
        if (len == index) {
            List<Integer> list = new ArrayList<>(len);
            for (int n : temp) list.add(n);
            ans.add(list);
        } else {
            for (int i = 0; i < len; i++) {
                int num = nums[i];
                if (num > 10 || (i > 0 && nums[i - 1] == num)) continue;
                temp[index] = num;
                nums[i] = 100;
                backtrack(nums, temp, index + 1);
                nums[i] = num;
            }
        }
    }
}
