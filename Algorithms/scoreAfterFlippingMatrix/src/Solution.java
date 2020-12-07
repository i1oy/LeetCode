public class Solution {
    public static void main(String[] args) {
        int[][] A = new int[][]{
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0},
        };
        Solution app = new Solution();
        System.out.println(app.matrixScore(A));

    }

    public int matrixScore(int[][] A) {
        int ans = 0;
        int m = A.length, n = A[0].length;
        // 将第一列的数字全部转换为1
        for (int i = 0; i < m; ++i) {
            if (A[i][0] == 0) {
                for (int j = 0; j < n; ++j) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        // 从第二列开始，保持每列中数字1的个数超过半数
        for (int j = 1; j < n; ++j) {
            int zeros = 0;
            for (int i = 0; i < m; ++i) {
                zeros += A[i][j] == 0 ? 1 : 0;
            }

            if (zeros > (m >> 1)) {
                for (int i = 0; i < m; ++i) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        // 计算结果
        for (int j = 0; j < n; ++j) {
            int sum = 0;
            for (int i = 0; i < m; ++i) {
                sum += A[i][j];
            }
            ans = ans * 2 + sum;
        }
        return ans;
    }
}
