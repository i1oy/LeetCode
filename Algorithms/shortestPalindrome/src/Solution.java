/**
 * 解题思路：
 *  将问题转化为查找字符串最长回文前缀：
 *  1. 获取字符串的中间位置；
 *  2. 向左右两边搜索，检查是否为回文字符串；
 *  3. 搜索停止时：
 *      1) 如果 left 越界，则说明从 0 到 right 的部分为回文串，仅需将 right 之后的字符串反转添加到原字符串之前即可；
 *      2) 如果 left 大于 0 ，则中间位置向前移动一位，重复第二个步骤；
 *
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).shortestPalindrome("aaaa"));
        System.out.println((new Solution()).shortestPalindrome("abbacd"));
        System.out.println((new Solution()).shortestPalindrome("abcd"));
        System.out.println((new Solution()).shortestPalindrome("abb"));
        System.out.println((new Solution()).shortestPalindrome("aabba"));
    }

    public String shortestPalindrome(String s) {
        int len = s.length();
        int mid = len % 2 == 1 ? len >> 1 : (len >> 1) - 1;
        int left = 0, right = 0;
        while (mid >= 0) {
            left = mid;
            while (left >= 0 && s.charAt(left) == s.charAt(mid)) --left;
            right = mid;
            while (right < len && s.charAt(right) == s.charAt(mid)) ++right;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                ++right;
                --left;
            }
            if (left < 0) break;
            --mid;
        }

        StringBuilder ans = new StringBuilder();

        if (left > 0) {
            ans.append(s.substring(1));
        } else {
            ans.append(s.substring(right));
        }
        ans.reverse();
        ans.append(s);

        return ans.toString();
    }
}
