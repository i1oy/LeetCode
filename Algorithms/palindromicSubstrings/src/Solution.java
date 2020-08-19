/**
 * 解题思路：
 *  1. 每个独立字符构成的子字符串都是一个回文串，因此每遍历到一个字符时计数加1；
 *  2. 从当前的字符向后搜索，如果后面的字符与当前字符相同，计数继续加1，直至遇到不同的字符；
 *  3. 在步骤2子串的基础上向左右方向搜索，如果左右方向的字符相同，计数继续加1；
 *      向左右方向搜索的时候，要剔除当前字符前一位字符相同的情况，避免重复计数；
 *  4. 重复步骤1，直至结束。
 *
 * 总结：
 *  解题的时候遇到2个错误: 1. 在执行步骤3时，向左右搜索时，如果条件不符合即可停止搜索，避免不符合回文的情况被计入；
 *                     2. 向左右方向搜索时，只要排除前一位字符相同的情况，避免符合回文的情况被排除在外。
 *  尽管提交的代码通过了，但是需要学习一下官方题解，解法会更加优美。
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb"));
    }
    public int countSubstrings(String s) {
        int ans = 0;
        int size = s.length();
        for (int i = 0; i < size; ++i) {
            ++ans;
            if (i >= size - 1) break;
            char c = s.charAt(i);
            int pos = i;
            while (pos + 1 < size && s.charAt(++pos) == c) {
                ++ans;
            }
            int offset = 1;
            while ((i - offset) >= 0 && (pos + offset - 1) < size) {
                if (s.charAt(i) != s.charAt(i - 1) && s.charAt(i - offset) == s.charAt(pos + offset - 1)) {
                    ++ans;
                } else {
                    break;
                }
                ++offset;
            }
        }

        return ans;
    }
}
