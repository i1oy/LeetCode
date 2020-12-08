import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(
                app.splitIntoFibonacci("123456579")
        );
        System.out.println(
                app.splitIntoFibonacci("11235813")
        );
    }
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        backtrack(ans, S, S.length(), 0, 0, 0);
        return ans;
    }

    private boolean backtrack(List<Integer> list, String S, int length, int index, int sum, int prev) {
        if (index >= length) return list.size() >= 3;

        long current = 0;
        for (int i = index; i < length; ++i) {
            if (i > index && S.charAt(index) == '0') break;
            current = current * 10 + S.charAt(i) - '0';
            if (current > Integer.MAX_VALUE) return false;

            int cur = (int) current;
            if (list.size() >= 2) {
                if (cur > sum)  break;
                else if (cur < sum) continue;
            }
            list.add(cur);
            if (backtrack(list, S, length, i + 1, prev + cur, cur))
            {
                return true;
            } else {
                list.remove(list.size() - 1);
            }

        }
        return false;
    }
}
