import java.util.Stack;

public class Solution {
    // 1614. Maximum Nesting Depth of the Parentheses #Easy
    public static void main(String[] args) {
        Solution app = new Solution();
        String[] strings = new String[]{
                "(1+(2*3)+((8)/4))+1",
                "(1)+((2))+(((3)))"
        };
        for (String s : strings)
            System.out.println(app.maxDepth(s));
    }

    public int maxDepth(String s) {
        int ans = 0, count = 0;
        for (Character c : s.toCharArray()) {
            if (c.equals('(')) ++count;
            else if (c.equals(')')) --count;
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
