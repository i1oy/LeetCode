public class Solution {
    /**
     * 2042. Check if Numbers Are Ascending in a Sentence
     */
    public boolean areNumbersAscending(String s) {
        boolean res = true;
        int prev = 0, current = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                current = current * 10 + (c - '0');
            } else if (c == ' ') {
                if (current > 0) {
                    if (current <= prev) {
                        res = false;
                        break;
                    }
                    prev = current;
                    current = 0;
                }
            }
        }
        res = current > 0 ? current > prev : res;
        return res;
    }
}
