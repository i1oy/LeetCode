import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.canReorderDoubled(new int[]{2, 4, 0, 0, 8, 1}));
        System.out.println(app.canReorderDoubled(new int[]{3, 1, 3, 6}));
        System.out.println(app.canReorderDoubled(new int[]{2, 1, 2, 6}));
        System.out.println(app.canReorderDoubled(new int[]{4, -2, 2, -4}));
    }

    /**
     * 954. Array of Doubled Pairs
     * 关键思路：
     * - 按绝对值对数组进行排序，绝对值最小的数必然要有 *2 后的数与之匹配；否则，返回 false；
     * - 使用哈希表来记录数值的个数，完成匹配后减去响应的个数；
     * @param arr
     * @return
     */
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int val : arr) counts.put(val, counts.getOrDefault(val, 0) + 1);
        if (counts.getOrDefault(0, 0) % 2 != 0) return false;
        List<Integer> vals = new ArrayList<Integer>(counts.keySet());
        Collections.sort(vals, Comparator.comparingInt(Math::abs));
        for (int val : vals) {
            if (counts.get(val) == 0) continue;
            if (counts.get(val) > counts.getOrDefault(val << 1, 0)) return false;
            counts.put(val << 1, counts.get(val << 1) - counts.get(val));
        }
        return true;
    }
}
