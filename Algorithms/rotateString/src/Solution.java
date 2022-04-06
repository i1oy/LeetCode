public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.rotateString("abcde", "cdeab"));
    }

    /**
     * 796. Rotate String
     * 解题思路：两段 s 拼接后，检查是否包含 goal
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        boolean ans = false;
        int len = s.length();
        if (len == goal.length()) {
            ans = (s + s).contains(goal);
        } else ans = false;
        return ans;
    }
}
