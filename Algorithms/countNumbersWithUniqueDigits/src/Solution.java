import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(
                app.countNumbersWithUniqueDigits(2)
        );
    }
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        n = n > 10 ? 10 : n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] * (11 - i);
        }
        return Arrays.stream(dp).sum();
    }
}
