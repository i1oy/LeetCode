public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(
                app.truncateSentence("What is the solution to this problem", 4)
        );
        System.out.println(
                app.truncateSentence("chopper is not a tanuki", 5)
        );
    }
    public String truncateSentence(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') ++count;
            if (count >= k) break;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
