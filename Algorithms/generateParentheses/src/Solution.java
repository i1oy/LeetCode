import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(
                new Solution().generateParenthesis(3)
        );
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        dfs(n, "", 0, 0, res);
        return res;
    }

    private void dfs(int n, String path, int open, int close, List<String> res) {
        if (open > n || open < close) return;
        if (path.length() == n * 2) {
            res.add(path.toString());
            return;
        }
        dfs(n, path + "(", open + 1, close, res);
        dfs(n, path + ")", open, close + 1, res);
    }
}
