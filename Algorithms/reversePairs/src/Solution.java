public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.reversePairs(
                new int[]{1, 3, 2, 3, 1}
        ));
        System.out.println(app.reversePairs(
                new int[]{233, 2000000001, 234, 2000000006, 235, 2000000003, 236, 2000000007, 237, 2000000002, 2000000005, 233, 233, 233, 233, 233, 2000000004}
        ));
    }

    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        return reversePairsRecursive(nums, 0, nums.length - 1);
    }

    public int reversePairsRecursive(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int n1 = reversePairsRecursive(nums, left, mid);
        int n2 = reversePairsRecursive(nums, mid + 1, right);
        int ret = n1 + n2;

        // 首先统计下标对的数量
        int i = left;
        int j = mid + 1;
        while (i <= mid) {
            while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            ret += j - mid - 1;
            i++;
        }

        // 随后合并两个排序数组
        int[] sorted = new int[right - left + 1];
        int p1 = left, p2 = mid + 1;
        int p = 0;
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid) {
                sorted[p++] = nums[p2++];
            } else if (p2 > right) {
                sorted[p++] = nums[p1++];
            } else {
                if (nums[p1] < nums[p2]) {
                    sorted[p++] = nums[p1++];
                } else {
                    sorted[p++] = nums[p2++];
                }
            }
        }
        for (int k = 0; k < sorted.length; k++) {
            nums[left + k] = sorted[k];
        }
        return ret;
    }
    // public int reversePairs(int[] nums) {
    //     int ans = 0;
    //     for (int i = 0; i < nums.length - 1; ++i) {
    //         int resrserNum = Integer.MAX_VALUE;
    //         for (int j = i + 1; j < nums.length; ++j) {
    //             if (nums[i] < nums[j]) continue;
    //             System.out.printf("%d, %d, Diff: %d\n", nums[i], nums[j], nums[j] - nums[i] + nums[j]);
    //             if (nums[j] - nums[i] + nums[j] < 0) {
    //                 ++ans;
    //             }
    //         }
    //     }
    //
    //     return ans;
    // }
}
