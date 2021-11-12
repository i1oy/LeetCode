public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.kInversePairs(3, 3));
        System.out.println(app.kInversePairs(2, 2));
        System.out.println(app.kInversePairs(3, 1));
        System.out.println(app.kInversePairs(2, 0));
        System.out.println(app.kInversePairs(1, 0));
    }

    public int kInversePairs(int n, int k) {
        int MOD = 1000000007;
        long[][] dp = new long[n + 1][k + 1];
        dp[1][0] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < Math.min(k, i * (i - 1) / 2) + 1; j++) {
                for (int a = Math.max(0, j - i + 1); a < j + 1; a++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][a]) % MOD;
                }
            }
        }
        return (int)dp[n][k];
    }
}
