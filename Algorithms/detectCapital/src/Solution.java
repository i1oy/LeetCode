public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        String[] words = new String[]{
                "USA", "Google", "FlaG", "a", "leetcode", "FFo"
        };
        for (String w : words) {
            System.out.println(app.detectCapitalUse(w));
        }
    }

    public boolean detectCapitalUse(String word) {
        boolean isUppercase = true;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c - 'a' >= 0 && c - 'z' <= 0) {
                if (isUppercase && i > 1)
                    return false;
                isUppercase = false;
            } else if (!isUppercase) {
                return false;
            }
        }
        return true;
    }
}
