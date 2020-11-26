public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(
                app.findMaxForm(new String[]{
                        "10", "0001", "111001", "1", "0"
                }, 5,3)
        );
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] count = countZeroesOnes(s);
            for (int zeroes = m; zeroes >= count[0]; --zeroes)
                for (int ones = n; ones >= count[1]; --ones)
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]],
                            dp[zeroes][ones]);
        }
        return dp[m][n];
    }

    private int[] countZeroesOnes(String s) {
        int[] counts = new int[2];
        for (char c : s.toCharArray()) {
            counts[c - '0']++;
        }
        return counts;
    }
}
