public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(
                app.maxCount(3, 3, new int[][]{})
        );
        System.out.println(
                app.maxCount(3, 3, new int[][]{
                        new int[]{2, 2},
                        new int[]{3, 3},
                })
        );

    }

    public int maxCount(int m, int n, int[][] ops) {
        int minX = m, minY = n;
        for (int[] op : ops) {
            minX = minX > op[0] ? op[0] : minX;
            minY = minY > op[1] ? op[1] : minY;
        }
        return minX * minY;
    }
}
