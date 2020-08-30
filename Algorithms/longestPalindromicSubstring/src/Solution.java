/**
 * 解题思路：
 *  依次遍历字符串中的各个字符，然后向左右方向扩展，记录最长回文字符串。
 *  扩展的过程中，首先要处理一下左右方向与中心字符相同的情况。
 */
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) return s;

        int longestLeftPos = 0, longestRightPos = 0;
        int left = 0, right = 0;

        int longestLen = 0;
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            left = i;
            while (left - 1 >= 0 && s.charAt(left - 1) == c) --left;
            right = i;
            while (right + 1 < len && s.charAt(right + 1) == c) ++right;
            while (left - 1 >= 0 && right + 1 < len && s.charAt(left - 1) == s.charAt(right + 1)) {
                --left;
                ++right;
            }
            if (longestLen < (right - left + 1)) {
                longestLeftPos = left;
                longestRightPos = right;
                longestLen = right - left + 1;
            }
        }

        return s.substring(longestLeftPos, longestRightPos + 1);
    }

    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.longestPalindrome("babab"));
        System.out.println(app.longestPalindrome("bb"));
        System.out.println(app.longestPalindrome(""));
    }

}
