import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        Solution app = new Solution();
        System.out.println(app.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int greed : g) {
            for (int i = 0; i < s.length; i++) {
                if (s[i] >= greed) {
                    ans++;
                    s[i] = -1;
                    break;
                }
            }
        }
        return ans;
    }
}