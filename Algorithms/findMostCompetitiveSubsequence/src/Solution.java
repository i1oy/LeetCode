import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 2, 6};
        Solution app = new Solution();
        System.out.println(Arrays.toString(app.mostCompetitive(nums, 2)));
        System.out.println(Arrays.toString(app.mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4)));
        System.out.println(Arrays.toString(app.mostCompetitive(new int[]{9, 6}, 1)));
        System.out.println(Arrays.toString(app.mostCompetitive(new int[]{9}, 1)));
        // [2,4,3,3,5,4,9,6], k = 4
    }

    public int[] mostCompetitive(int[] nums, int k) {
        int[] ans = new int[k];
        int top = -1, len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            while (top >= 0 && ans[top] > num && len - i >= k - top) --top;
            if (top < k - 1) ans[++top] = num;
        }
        return ans;
    }
}
