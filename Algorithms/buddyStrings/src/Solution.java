import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.buddyStrings("ab", "ab"));
        System.out.println(app.buddyStrings("aa", "aa"));
        System.out.println(app.buddyStrings("aaaaaaabc", "aaaaaaacb"));

    }
    public boolean buddyStrings(String s, String goal) {
        boolean res = false;
        int[] counts = new int[26];
        if (s.length() == goal.length()) {
            int len = s.length();
            List<Integer> diff = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                counts[s.charAt(i) - 'a']++;
                if (s.charAt(i) != goal.charAt(i))
                    diff.add(i);
            }
            if (diff.size() == 2) {
                int first = diff.get(0);
                int second = diff.get(1);
                if (s.charAt(first) == goal.charAt(second)
                && s.charAt(second) == goal.charAt(first))
                    res = true;
            } else if (diff.size() == 0) {
                for (int count : counts) {
                    if (count >= 2) {
                        res = true;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
