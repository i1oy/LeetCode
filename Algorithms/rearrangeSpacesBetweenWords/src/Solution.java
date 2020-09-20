/**
 * 题目来源：第207场周赛，2020-09-20
 * 解题思路：
 *  统计单词数量和空格数量，然后重组字符串。
 *  需要关注的点：
 *      1. 手动扫描字符串统计单词数量时，当扫描结束后，如果isInWord为真值，
 *          那么就要增加单词的计数；
 *      2. 仅有一个单词时，特殊处理，避免出现除以0的情况；
 *      3. 仅有一个单词时，所有的空格都是extraSpace.
 *
 * Tips:
 *  快速创建含有N个空格的字符串：
 *      `String extra = new String(new char[extraSpace]).replace('\0', ' ');`
 */
public class Solution {

    public static void main(String[] args) {
        Solution app = new Solution();
        String[] textArr = {
                "  this   is  a sentence ",
                " practice   makes   perfect",
                "hello   world",
                "  walks  udp package   into  bar a",
                "a",
                "   Hello"
        };

        for (String text : textArr) {
            System.out.println(app.reorderSpaces(text) + "|");
        }
    }

    public String reorderSpaces(String text) {
        int len = text.length();
        StringBuilder ans = new StringBuilder(len);
        int spaceCount = 0, wordCount = 0;
        boolean isInWord = false;
        for (int i = 0; i < len; ++i) {
            char c = text.charAt(i);
            if (c == ' ') {
                ++spaceCount;
                if (isInWord) {
                    ++wordCount;
                    isInWord = false;
                }
            } else {
                if (!isInWord) {
                    isInWord = true;
                }
            }
        }

        if (isInWord) {
            ++wordCount;
        }

        int gapSpacesCount = 0, extraSpace;
        if (wordCount > 1) {
             gapSpacesCount = spaceCount / (wordCount - 1);
             extraSpace = spaceCount % (wordCount - 1);
        } else {
            extraSpace = spaceCount;
        }
        String gap = new String(new char[gapSpacesCount]).replace('\0', ' ');
        isInWord = false;

        int count = 0;
        for (int i = 0; i < len; ++i) {
            char c = text.charAt(i);
            if (c != ' ') {
                if (!isInWord) isInWord = true;
                ans.append(c);
            } else {
                if (isInWord) {
                    isInWord = false;
                    if (count < wordCount - 1 && gapSpacesCount > 0)
                        ans.append(gap);
                    ++count;
                }
            }
        }

        if (extraSpace > 0) {
            String extra = new String(new char[extraSpace]).replace('\0', ' ');
            ans.append(extra);
        }
        return ans.toString();
    }
}
