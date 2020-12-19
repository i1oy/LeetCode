import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] piles = new int[] {
                5,3,4,5
        };
        Solution app = new Solution();
        System.out.println(app.stoneGame(piles));
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
            memo[i][i] = piles[i];
        }
        return score(piles, 0, piles.length - 1, memo) > 0;
    }

    private int score(int[] piles, int left, int right, int[][] memo) {
        if (left > right) return 0;
        if (left == right) return piles[left];
        if (memo[left][right] != Integer.MIN_VALUE) {
            return memo[left][right];
        }
        int res = Math.max(
                piles[left] - score(piles, left + 1, right, memo),
                piles[right] - score(piles, left, right - 1, memo)
        );
        memo[left][right] = res;
        return res;
    }
}
