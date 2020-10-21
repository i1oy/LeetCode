/**
 * 解题思路：
 *  使用`i, j`双指针追踪每个字符，其中基础逻辑是：
 *      若`name[i] == typed[j]`，i, j分别增加1；
 *      否则，若`typed[j - 1] == type[j]`，说明typed出现长按情况，j增加1；
 *      所有字符串遍历结束后，若`i == name.length()`，则返回true.
 *  细节逻辑：
 *      typed字符串的长度大于等于name，选择typed来遍历，
 *          可以避免当name遍历完成后处理"typed字符串尾巴"的问题；
 *      `typed[j - 1] == type[j]`的情况要求j要大于0；
 */
public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(
                app.isLongPressedName("alex", "aaleexxr")
        );
        System.out.println(
                app.isLongPressedName("saeed", "ssaaeedd")
        );

        System.out.println(
                app.isLongPressedName("pyplrz","ppyypllrzzz")
        );
    }

    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                ++i;
                ++j;
            } else if (j > 0 && typed.charAt(j - 1) == typed.charAt(j)){
                ++j;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}
