import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.canConstruct("a", "b"));
        System.out.println(app.canConstruct("aa", "ab"));
        System.out.println(app.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphaStats = new int[26];
        for (char c : magazine.toCharArray()) {
            alphaStats[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--alphaStats[c - 'a'] < 0) return false;
        }
        return true;
        // Map<Character, Integer> map = new HashMap<>();
        // for (char c : ransomNote.toCharArray()) {
        //     map.put(c, map.getOrDefault(c, 0) + 1);
        // }
        // for (char c : magazine.toCharArray()) {
        //     if (map.get(c) != null && map.get(c) > 0) {
        //         map.put(c, map.get(c) - 1);
        //         if (map.get(c) == 0) map.remove(c);
        //     }
        // }
        // return map.isEmpty();
    }
}
