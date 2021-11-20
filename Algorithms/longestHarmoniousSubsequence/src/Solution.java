import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        int[][] numsArr = new int[][]{
                new int[]{1, 2, 2, 1},
                new int[]{1, 3, 2, 2, 5, 2, 3, 7},
                new int[]{1, 2, 3, 4},
                new int[]{1, 1, 1, 1, 1}
        };
        for (int[] nums : numsArr)
            System.out.println(app.findLHS(nums));
    }

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        Map<Integer, Integer> starts = new HashMap<>();
        Map<Integer, Integer> ends = new HashMap<>();
        starts.put(nums[0], 0);
        ends.put(nums[nums.length  -  1], nums.length - 1);
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                ends.put(prev, i - 1);
                prev = nums[i];
                starts.put(nums[i], i);
            }
        }

        for (Integer start : starts.keySet()) {
            if (ends.get(start + 1) != null) {
                res = Math.max(res, ends.get(start + 1) - starts.get(start) + 1);
            }
        }
        return res;
    }
}
