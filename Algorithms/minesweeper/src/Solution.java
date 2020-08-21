import java.util.Arrays;

/**
 * 解题思路：
 *  1. 处理最简单的情况： 点击到地雷'M'，置为'X'，返回结果;
 *  2. 处理点击到未挖出的空方块'E'的情况：
 *      a. 方块周围无地雷，则向上下左右及对角共8个方向扩展，递归处理；
 *      b. 方块周围有地雷，则统计地雷数量，记入到当前方块，直接返回；
 *      c. 对外扩展时，遇到非'E'的情况，直接返回；
 *  3. 其他情况，直接返回。
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        char[][] board2 = {
                {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}
        };
        System.out.println(Arrays.deepToString(solution.updateBoard(board, new int[]{0, 2})));
    }

    int row = 0, col = 0;

    int[][] directions = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1},
            {-1, -1}, {1, -1}, {1, 1}, {-1, 1},
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        row = board.length;
        col = board[0].length;
        int x = click[0];
        int y = click[1];
        char clickedBlock = board[x][y];
        if (clickedBlock == 'M') {
            board[x][y] = 'X';
        } else if (clickedBlock == 'E') {
            helper(board, x, y);
        }

        return board;
    }

    private void helper(char[][] board, int x, int y) {
        if (board[x][y] != 'E') return;
        int mineCount = 0;
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                continue;
            }
            if (board[newX][newY] == 'M') {
                ++mineCount;
            }
        }

        if (mineCount > 0) {
            board[x][y] = (char) ('0' + mineCount);
        } else {
            board[x][y] = 'B';
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                    continue;
                }
                helper(board, newX, newY);
            }
        }
    }
}
