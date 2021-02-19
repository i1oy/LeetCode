public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        int[][] arrs = {
                {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}
        };
        for (int i = 0; i < arrs.length; ++i) {
            System.out.println(app.longestOnes(arrs[i], 0));
        }
    }

    public int longestOnes(int[] A, int K) {
        int res = 0;
        int l = 0, r = 0;
        int len = A.length;
        int zeros = 0;
        while (r < len) {
            if (A[r] == 0) {
                res = Math.max(res, r - l);
                if (++zeros > K) {
                    while (zeros > K) {
                        if (A[l++] == 0) zeros--;
                    }
                }
            }
            ++r;
        }
        res = Math.max(res, r - l);
        return res;
    }
}
