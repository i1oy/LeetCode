public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(
                app.validMountainArray(new int[]{1, 3, 2,})
        );
    }

    public boolean validMountainArray(int[] A) {
        int len = A.length, i = 1;
        // 爬坡阶段
        while (i < len && A[i - 1] < A[i]) ++i;
        // 检查峰顶是否处于中间位置
        if (i - 1 == 0 || i == len) return false;
        // 下山阶段
        while (i < len && A[i - 1] > A[i]) ++i;
        return i == len;
    }
}
