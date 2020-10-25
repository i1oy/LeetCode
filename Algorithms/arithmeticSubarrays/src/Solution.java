import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        int[] nums = {
                -12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10
        };
        int[] l = {
                0, 1, 6, 4, 8, 7
        };
        int[] r = {
                4, 4, 9, 7, 9, 10
        };

        System.out.println(app.checkArithmeticSubarrays(nums, l, r));
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int len = l.length;
        List<Boolean> ans = new ArrayList<>(len);
        for (int i = 0; i < len; ++i) {
            int left = l[i];
            int right = r[i];
            if (right - left < 2) {
                ans.add(true);
            } else {
                int[] temp = new int[right - left + 1];
                for (int pos = left; pos <= right; ++pos) {
                    temp[pos - left] = nums[pos];
                }
                Arrays.sort(temp);
                boolean flag = true;
                for (int p = 2; p < temp.length; ++p) {
                    if (temp[p] - temp[p - 1] != temp[p - 1] - temp[p - 2])
                        flag = false;
                }
                ans.add(flag);
            }
        }
        return ans;
    }

}
