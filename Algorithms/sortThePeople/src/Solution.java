import java.util.*;

public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int len = names.length;
        String[] res = new String[len];
        Map m = new HashMap<Integer, String>();
        for (int i = 0; i < len; ++i) {
            int h = heights[i];
            String name = names[i];
            m.put(h, name);
        }

        Arrays.sort(heights);

        int index = 0;
        for (int i = len - 1; i >= 0; --i) res[index++] = (String) m.get(heights[i]);

        return res;
    }
}
