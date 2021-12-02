import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();

        System.out.println(
                Arrays.toString(app.maxNumber(new int[]{
                        7, 6, 1, 9, 3, 2, 3, 1, 1
                }, new int[]{
                        4, 0, 9, 9, 0, 5, 5, 4, 7
                }, 9))
        );
        System.out.println(
                Arrays.toString(app.maxNumber(new int[]{
                        5, 1, 0
                }, new int[]{
                        5, 2, 1
                }, 3))
        );
        System.out.println(
                Arrays.toString(app.maxNumber(new int[]{
                        6, 7
                }, new int[]{
                        6, 0, 4
                }, 5))
        );
        System.out.println(
                Arrays.toString(app.maxNumber(new int[]{
                        3, 9
                }, new int[]{
                        8, 9
                }, 3))
        );
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int m = nums1.length, n = nums2.length;
        int start = Math.max(0, k - n), end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            int[] maxSubsequence1 = this.maxSubsequence(nums1, i);
            int[] maxSubsequence2 = this.maxSubsequence(nums2, k - i);
            int[] mergeSeq = this.mergeSeq(maxSubsequence1, maxSubsequence2, k);
            if (this.compareSequence(res, 0, mergeSeq, 0) < 0)
                System.arraycopy(mergeSeq, 0, res, 0, k);
        }
        return res;
    }

    private int[] maxSubsequence(int[] nums, int size) {
        if (size < 1) return new int[size];
        int[] res = new int[size];
        int len = nums.length;
        int index = -1;

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            int remainder = len - i;
            while (index >= 0 && num > res[index] && remainder >= size - index) --index;
            if (index < size - 1)
                res[++index] = num;
        }
        return res;
    }

    private int[] mergeSeq(int[] seq1, int[] seq2, int size) {
        int[] res = new int[size];
        int index = 0, i = 0, j = 0;
        int m = seq1.length, n = seq2.length;
        while (index < size) {
            if (i == m) res[index++] = seq2[j++];
            else if (j == n) res[index++] = seq1[i++];
            else {
                if (this.compareSequence(seq1, i, seq2, j) > 0) res[index++] = seq1[i++];
                else res[index++] = seq2[j++];
            }
        }
        return res;
    }

    private int compareSequence(int[] seq1, int index1, int[] seq2, int index2) {
        int m = seq1.length, n = seq2.length;
        while (index1 < m && index2 < n) {
            int diff = seq1[index1] - seq2[index2];
            if (diff != 0) return diff;
            ++index1;
            ++index2;
        }
        return (m - index1) - (n - index2);
    }
}