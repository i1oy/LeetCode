/**
 * 解题思路：
 *  遍历字符串，记录非空字符的起止位置，当遇到空格时，非空字符的终止位置为空格的前一个位置。
 *  照逆序添加到结果字符串中，并将空字符串添加到结果中；继续向后遍历。
 *  特殊情况：连续空格字符，此时记录的非空字符的终止位置小于起始位置，退化为添加空字符到结果中(实际题目中已经排查了这种情况，多余了）；
 *          遍历到最后位置时，非空字符的终止位置即为当前位置。
 */

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.reverseWords("Let's take LeetCode contest"));
        System.out.println(app.reverseWords("  I Love U  ") + "｜");
    }

    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int start = -1, end = -2;
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            if (start < 0) {
                start = i;
            }
            if (s.charAt(i) == ' ' || i == len - 1) {
                if (start >= 0) end = i == len - 1 ? i : i - 1;
                while (end >= start) {
                    ans.append(s.charAt(end));
                    --end;
                }
                start = -1;
                end = -2;
            }

            if (s.charAt(i) == ' ') {
                ans.append(" ");
            }

        }
        return ans.toString();
    }
}
