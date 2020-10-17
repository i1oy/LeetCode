import java.util.HashSet;
import java.util.Set;

/**
 * 解题思路：
 * 常规解法。
 * 分别使用三个集合存储不可放置棋子的列和对角线的信息：
 * 设当前棋子的位置为(x, y),
 * 1. 列的处理最简单：如果当前位置放置棋子，那么该列(* ,y)后续则不可放置；
 * 2. 对角线的情况包含两种情况：
 * a. 如果 i + j == x + y, 则(i, j)在对角线上；
 * b. 如果 i - j == x - y, 则(i, j)在对角线上。
 * <p>
 * TIP: 考虑到对称的情况，那么遍历第一行的时候，只需计算0～(n/2)列的位置。
 */

public class Solution {

    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.totalNQueens(8));
    }

    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag1 = new HashSet<>();
    Set<Integer> diag2 = new HashSet<>();
    int colNumInFirstLine = 0;
    int ans = 0;


    public int totalNQueens(int n) {
        helper(0, n);
        return ans;
    }

    private void helper(int row, int n) {
        if (row == n) {
            ++ans;
            if (n % 2 == 0) {
                ++ans;
            } else {
                if (colNumInFirstLine < (n >> 1)) {
                    ++ans;
                }
            }
            return;
        } else {
            for (int col = 0; col < n; ++col) {
                if (row == 0) {
                    colNumInFirstLine = col;
                    boolean stopFlag = n % 2 == 0 ?
                            (col >= (n >> 1)) : (col > (n >> 1));
                    if (stopFlag) break;
                }
                if (cols.contains(col) || diag1.contains(row + col) || diag2.contains(row - col)) {
                    continue;
                }
                cols.add(col);
                diag1.add(row + col);
                diag2.add(row - col);
                helper(row + 1, n);
                cols.remove(col);
                diag1.remove(row + col);
                diag2.remove(row - col);
            }
        }
    }
}
