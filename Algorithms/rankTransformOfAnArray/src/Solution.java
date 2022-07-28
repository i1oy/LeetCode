import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class Solution {
    /**
     * 1331. Rank Transform of an Array
     * 解题思路：排序 + 哈希表
     * @param arr
     * @return
     */
    public int[] arrayRankTransform(int[] arr) {
        int[] res = new int[arr.length];
        int[] clone = arr.clone();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(clone);
        int index = 1;
        for (int num : clone) if (!map.containsKey(num)) map.put(num, index++);
        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}
