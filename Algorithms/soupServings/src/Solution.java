public class Solution {
    /**
     * 808. Soup Servings
     *
     * @param n
     * @return
     */
    private double res = 0;
    private double[][] memo;
    public double soupServings(int n) {
        n = (n + 24) / 25;
        // 返回值在正确答案 10e-5 的范围内将被认为是正确的
        // 实际计算过程中，发现当 n >= 179*25 时，返回 1.0 即可
        if (n >= 179) return 1.0;
        memo = new double[n + 1][n + 1];
        return helper(n, n, 1);
    }

    private double helper(int soupA, int soupB, double probability) {
        if (soupA <= 0) {
            probability = soupB <= 0 ? probability * 0.5 : probability;
            return probability;
        } else if (soupB <= 0) return 0;
        if (memo[soupA][soupB] == 0) {
            memo[soupA][soupB] = helper(soupA - 4, soupB, probability * 0.25)
                    + helper(soupA - 3, soupB - 1, probability * 0.25)
                    + helper(soupA - 2, soupB - 2, probability * 0.25)
                    + helper(soupA - 1, soupB - 3, probability * 0.25);
        }
        return memo[soupA][soupB];
    }
}
