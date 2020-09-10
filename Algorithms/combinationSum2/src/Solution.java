import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        int[] candidates = new int[]{
                10, 1, 2, 7, 6, 1, 5
        };
        System.out.println(app.combinationSum2(candidates, 8));
    }

    List<int[]> freq = new ArrayList<>();
    List<Integer> sequence = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }

        dfs(0, target);
        return ans;
    }

    private void dfs(int pos, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<>(sequence));
            return;
        }

        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        dfs(pos + 1, rest);
        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }

}
