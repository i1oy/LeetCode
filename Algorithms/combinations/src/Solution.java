import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.combine(4, 2));
    }

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    private void dfs(int current, int n, int k) {
        if (temp.size() + (n - current + 1) < k) return;
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(current);
        dfs(current + 1, n, k);
        temp.remove(temp.size() - 1);
        dfs(current + 1, n, k);
    }
}
