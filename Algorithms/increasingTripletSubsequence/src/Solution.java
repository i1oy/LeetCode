public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        int[][] numss = new int[][]{
                new int[]{1, 2, 3, 4, 5},
                new int[]{5, 4, 3, 2, 1},
                new int[]{100, 101, 80, 81, 1, 999}
        };
        for (int[] nums : numss) {
            System.out.println(app.increasingTriplet(nums));
        }
    }

    // 334. Increasing Triplet Subsequence
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > second) return true;
            if (first < num && second > num) second = num;
            if (first > num) first = num;
        }
        return false;
    }
}
