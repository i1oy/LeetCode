public class Solution {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 2, 2},
                {2, 3, 2}
        };
        int[][] grid2 = new int[][]{
                {1, 1}, {1, 2}
        };
        int[][] grid3 = new int[][]{
                {1, 1, 1}, {1, 1, 1}, {1, 1, 1}
        };
        Solution app = new Solution();
        app.colorBorder(grid, 0, 1, 3);
        app.colorBorder(grid2, 0, 0, 3);
        app.colorBorder(grid3, 1, 1, 2);
    }

    // 1034. Coloring A Border
    private int[][] DIRECTIONS = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    private boolean[][] coloring;
    private boolean[][] visited;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        coloring = new boolean[m][n];
        visited = new boolean[m][n];
        int originalColor = grid[row][col];
        dfs(grid, m, n, row, col, originalColor);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) if (coloring[i][j]) grid[i][j] = color;
        }
        return grid;
    }

    private void dfs(int[][] grid, int m, int n, int row, int col, int originalColor) {
        if (row < 0 || row >= m || col < 0 || col >= n) return;
        if (visited[row][col] || grid[row][col] != originalColor) return;
        visited[row][col] = true;
        if (row == m - 1 || row == 0 || col == n - 1 || col == 0) coloring[row][col] = true;
        else {
            int val = grid[row][col];
            for (int[] d : DIRECTIONS) {
                if (row + d[0] < m && row + d[0] >= 0
                        && col + d[1] < n && col + d[1] >= 0
                        && val != grid[row + d[0]][col + d[1]]) coloring[row][col] = true;
            }
        }
        for (int[] d : DIRECTIONS) dfs(grid, m, n, row + d[0], col + d[1], originalColor);
    }
}
