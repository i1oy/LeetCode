import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.findCheapestPrice(
                5, new int[][]{
                        {4, 1, 1},
                        {1, 2, 3},
                        {0, 3, 2},
                        {0, 4, 10},
                        {3, 1, 1},
                        {1, 4, 3}
                }, 2, 1, 1
        ));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        long[][] dp = new long[K + 2][n];
        for (long[] x : dp) {
            Arrays.fill(x, Integer.MAX_VALUE);
        }
        int i = 0;
        while (i <= K + 1) {
            dp[i++][src] = 0;
        }

        i = 1;
        while (i <= K + 1) {
            for (int[] flight : flights) {
                dp[i][flight[1]] = Math.min(
                        dp[i - 1][flight[0]] + flight[2],
                        dp[i][flight[1]]
                );
            }
            ++i;
        }
        return dp[K + 1][dst] >= Integer.MAX_VALUE ? -1 : (int) dp[K + 1][dst];
    }
}
