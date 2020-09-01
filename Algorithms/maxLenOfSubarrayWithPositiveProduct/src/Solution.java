public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.getMaxLen(new int[]{1, 2, 3, 5, -6, 4, 0, 10}));
        System.out.println(app.getMaxLen(new int[]{0, 1, -2, -3, -4}));
        System.out.println(app.getMaxLen(new int[]{1, -2, -3, 4}));
        System.out.println(app.getMaxLen(new int[]{-1, 2, 3, 0, 1}));
    }

    public int getMaxLen(int[] nums) {
        int ans = 0;
        int len = nums.length;
        int[] pos = new int[len];
        int[] neg = new int[len];
        pos[0] = nums[0] > 0 ? 1 : 0;
        neg[0] = nums[0] < 0 ? 1 : 0;
        ans = pos[0];

        for (int i = 1; i < len; ++i) {
            int cur = nums[i];
            if (cur == 0) {
                pos[i] = 0;
                neg[i] = 0;
            } else if (cur > 0) {
                pos[i] = pos[i - 1] + 1;
                if (neg[i - 1] > 0) {
                    neg[i] = neg[i - 1] + 1;
                }
            } else {
                neg[i] = pos[i - 1] + 1;
                if (neg[i - 1] > 0) {
                    pos[i] = neg[i - 1] + 1;
                }
            }
            ans = ans > pos[i] ? ans : pos[i];
        }
        return ans;
    }
}
