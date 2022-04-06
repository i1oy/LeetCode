import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 136. Single Number
     * 解题思路：哈希表记录
     * 官方题解：使用异或运算（题目中的一个条件，重复的数字均出现2次）
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num:nums) ans ^= num;
        return ans;
    }
    // public int singleNumber(int[] nums) {
    //     int ans = nums[0];
    //     if (nums.length > 1) {
    //         Map<Integer, Integer> map = new HashMap<>();
    //         for (int num : nums) {
    //             map.put(num, map.getOrDefault(num, 0) + 1);
    //         }
    //         for (int k : map.keySet()) {
    //             if (map.get(k) == 1) ans = k;
    //         }
    //     }
    //     return ans;
    // }
}
