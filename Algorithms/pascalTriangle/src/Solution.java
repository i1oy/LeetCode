import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        for (List<Integer> row : app.generate(5)) {
            System.out.println(row);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; ++i) {
            Integer[] current = new Integer[i];
            List<Integer> prev = i > 2 ? ans.get(i - 2) : null;
            for (int j = 0; j < ((i + 1) >> 1); ++j) {
                int num = 1;
                if (j > 0) {
                    num = prev.get(j) + prev.get(j - 1);
                }
                // 对称
                current[j] = num;
                current[i - 1 - j] = num;
            }
            ans.add(Arrays.asList(current));
        }
        return ans;
    }
}
