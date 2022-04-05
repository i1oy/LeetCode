import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        String[] testCases = new String[]{
                "cc", "fwejfldskjf", "dskj", "aaaaaaaa", "", "c"
        };
        for (String t : testCases) {
            System.out.println(app.maxLengthBetweenEqualCharacters(t));
        }
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int temp = i - map.get(c) - 1;
                ans = temp > ans ? temp : ans;
            } else {
                map.put(c, i);
            }
        }
        return ans;
    }
}
