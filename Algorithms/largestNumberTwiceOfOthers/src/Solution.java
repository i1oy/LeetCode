public class Solution {

    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(app.dominantIndex(new int[]{1, 2, 3, 4}));
        System.out.println(app.dominantIndex(new int[]{1}));
        System.out.println(app.dominantIndex(new int[]{3, 6}));
        System.out.println(app.dominantIndex(new int[]{2, 1}));
    }

    // 747. Largest Number At Least Twice of Others
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int[] largest = new int[]{-1, -1};
        int secondLargest = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > largest[0]) {
                if (largest[0] > secondLargest) {
                    secondLargest = largest[0];
                }
                largest[0] = num;
                largest[1] = i;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }
        return largest[0] >= (secondLargest << 1) ? largest[1] : -1;
    }
}
