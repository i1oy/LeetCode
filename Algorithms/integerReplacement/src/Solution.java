public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        for (int i : new int[]{8, 7, 4 , 1, Integer.MAX_VALUE}) {
            System.out.println(app.integerReplacement(i));
        }
    }

    public int integerReplacement(int n) {
        return dfs(n, 0);
    }

    private int dfs(int n, int times) {
        if (n == 1) return times;
        if (n % 2 == 0) return dfs(n  >> 1, times + 1);
        return Math.min(dfs((n >> 1) + 1, times + 2),
                dfs(n >> 1, times + 2));
    }
}
