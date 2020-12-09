class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(
                app.uniquePaths(7, 3)
        );
        System.out.println(
                app.uniquePaths(3, 7)
        );
        System.out.println(
                app.uniquePaths(3, 3)
        );
        System.out.println(
                app.uniquePaths(3, 2)
        );

    }

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; ++i) {
            grid[i][n - 1] = 1;
        }
        for (int j = 0; j < n; ++j) {
            grid[m - 1][j] = 1;
        }

        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                grid[i][j] = grid[i + 1][j] + grid[i][j + 1];
            }
        }
        return grid[0][0];
    }
}