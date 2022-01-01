public class Solution {
    // 2022. Convert 1D Array Into 2D Array
    public static void main(String[] args) {
        Solution app = new Solution();
        int[] original = new int[]{1, 2, 3};
        int[][] convertedArray = app.construct2DArray(original, 1, 1);
        for (int i = 0; i < convertedArray.length; i++) {
            for (int j = 0; j < convertedArray[0].length; j++) {
                System.out.printf("%d ", convertedArray[i][j]);
            }
            System.out.println("");
        }
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length == m * n) {
            int[][] ans = new int[m][n];
            for (int i = 0; i < original.length; i++) {
                ans[i / n][i % n] = original[i];
            }
            return ans;
        } else
            return new int[0][0];
    }
}
