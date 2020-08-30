/**
 * 解题思路：
 *  暴力破解
 */
public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(Boolean.toString(
                app.containsPattern(new int[]{1, 2, 4, 4, 4, 4}, 1, 4)
        ));

        System.out.println(Boolean.toString(
                app.containsPattern(new int[]{1, 2, 3, 1, 2}, 2, 2)
        ));

        System.out.println(Boolean.toString(
                app.containsPattern(new int[]{1, 2, 1, 2, 1, 3, 4, 5, 8}, 2, 3)
        ));

        System.out.println(Boolean.toString(
                app.containsPattern(new int[]{2, 2, 2, 2}, 2, 3)
        ));

    }

    public boolean containsPattern(int[] arr, int m, int k) {
        int len = arr.length;
        if (m * k > len) return false;
        int[] pattern = new int[m];
        int index = 0;
        while (index + m * k - 1 < len) {
            for (int i = 0; i < m; ++i) {
                pattern[i] = arr[index + i];
            }

            int count = 1;
            while (index + m * count - 1 < len) {
                boolean match = true;
                for (int i = 0; i < m; ++i) {
                    if (pattern[i] != arr[index + m * count + i]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    ++count;
                    if (count >= k) return true;
                } else {
                    break;
                }
            }
            ++index;
        }
        return false;
    }
}
