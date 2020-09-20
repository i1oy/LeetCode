/**
 * 题目来源：第207场周赛，2020-09-20
 * 解题思路：
 *  使用递归方式进行求解。
 *  处理超时问题：在乘积为0的时候，与当前的ans进行对比，反馈结果，避免无用的计算。
 */

public class Solution {

    public static void main(String[] args) {
        int[][] grid = {
                {-1, -2, -3},
                {-2, -3, -3},
                {-3, -3, -2}
        };
        int[][] grid2 = {
                {1, -2, 1},
                {1, -2, 1},
                {3, -4, 1}
        };

        int[][] grid3 = {
                {2, 1, 3, 0, -3, 3, -4, 4, 0, -4},
                {-4, -3, 2, 2, 3, -3, 1, -1, 1, -2},
                {-2, 0, -4, 2, 4, -3, -4, -1, 3, 4},
                {-1, 0, 1, 0, -3, 3, -2, -3, 1, 0},
                {0, -1, -2, 0, -3, -4, 0, 3, -2, -2},
                {-4, -2, 0, -1, 0, -3, 0, 4, 0, -3},
                {-3, -4, 2, 1, 0, -4, 2, -4, -1, -3},
                {3, -2, 0, -4, 1, 0, 1, -3, -1, -1},
                {3, -4, 0, 2, 0, -2, 2, -4, -2, 4},
                {0, 4, 0, -3, -4, 3, 3, -1, -2, -2}
        };

        Solution app = new Solution();
        System.out.println(app.maxProductPath(grid));
        System.out.println(app.maxProductPath(grid2));
        System.out.println(app.maxProductPath(grid3));
    }

    long ans = -1;
    int totalRows = 0, totalCols = 0;
    public int maxProductPath(int[][] grid) {
        long product = 1;
        totalRows = grid.length;
        totalCols = grid[0].length;
        helper(grid, totalRows - 1, totalCols - 1, product);
        return (int) (ans % 1000000007);
    }

    private void helper(int[][] grid, int row, int col, long product) {
        if (row < 0 || col < 0) return;

        product = product * (long) grid[row][col];
        if ((row == 0 && col == 0) || product == 0) {
            ans = product > ans ? product : ans;
            return;
        }
        helper(grid, row - 1, col, product);
        helper(grid, row, col - 1, product);
    }
}
