public class Solution {
    /**
     * 821. Shortest Distance to a Character
     * @param s
     * @param c
     * @return
     */
    public int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int offset = 0;
            while (true) {
                if (i - offset >= 0 && chars[i - offset] == c) {
                    ans[i] = offset;
                    break;
                }
                if (i + offset < len && chars[i + offset] == c) {
                    ans[i] = offset;
                    break;
                }
                ++offset;
            }
        }
        return ans;
    }
}
