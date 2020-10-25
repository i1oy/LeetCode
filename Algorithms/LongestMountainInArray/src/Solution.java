public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        int[] A = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(app.longestMountain(A));
        int[] A2 = {875, 884, 239, 731, 723, 685};
        System.out.println(app.longestMountain(A2));
    }

    public int longestMountain(int[] A) {
        int ans = 0;
        int len = A.length;
        if (len >= 3) {
            int left, right = 0;
            int current = 0;
            while (current + 1 < len) {
                // 当发现开始进入爬升标识的时候，开始计算当前山脉长度
                if (A[current] < A[current + 1]) {
                    left = current++;
                    while (current + 1 < len && A[current] < A[current + 1]) {
                        ++current;
                    }
                    while (current + 1 < len && A[current] > A[current + 1]) {
                        ++current;
                        right = current;
                    }

                    if (right > left && ans < (right - left + 1))
                        ans = right - left + 1;
                } else {
                    // 未发现爬升标识，向后遍历
                    ++current;
                }
            }
        }
        return ans;
    }
}
