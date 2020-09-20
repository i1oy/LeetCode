import javax.security.auth.login.CredentialNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解题思路：
 *  参考官方题解的思路：使用0～2^n-1之间所有的二进制数来枚举子集的所有结果。
 */

public class Solution {

    public static void main(String[] args) {
        Solution app = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(
                Arrays.deepToString(new List[]{app.subsets(nums)})
        );
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int len = nums.length;

        for (int mask = 0; mask < (1 << len); ++mask) {
            temp.clear();
            int pos = 0;
            while ((1 << pos) <= mask) {
                if ((mask & (1 << pos)) != 0) {
                    temp.add(nums[pos]);
                }
                ++pos;
            }
            ans.add(new ArrayList<>(temp));
        }

        return ans;
    }

}
