import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Solution {
    /**
     * 819. Most Common Word
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        String ans = null;
        Map<String, Integer> map = new HashMap<>();
        boolean wordFlag = false;
        StringBuilder word = new StringBuilder();
        for (Character c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) word.append(c);
            else {
                if (word.length() > 0) {
                    String w = word.toString().toLowerCase();
                    map.put(w, map.getOrDefault(w, 0) + 1);
                    word.setLength(0);
                }
            }
        }
        if (word.length() > 0) {
            String w = word.toString().toLowerCase();
            map.put(w, map.getOrDefault(w, 0) + 1);
            word.setLength(0);
        }
        int max = -1;
        for (String w : map.keySet()) {
            boolean isBanned = false;
            for (String b : banned) {
                if (b.equals(w)) {
                    isBanned = true;
                    break;
                }
            }
            if (!isBanned && map.get(w) > max) {
                ans = w;
                max = map.get(w);
            }
        }
        return ans;
    }
}

