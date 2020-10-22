import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(
                (app.partitionLabels("a"))
        );
    }
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int len = S.length();
        int start = 0, end = 0;
        while (start < len){
            char c = S.charAt(start);
            int lastIndex = len - 1;
            while (lastIndex >= start) {
                if (S.charAt(lastIndex) == c) {
                    break;
                }
                --lastIndex;
            }
            end = lastIndex;
            int current = start + 1;
            while (current < end) {
                char c2 = S.charAt(current);
                lastIndex = len - 1;
                while (lastIndex >= current) {
                    if (S.charAt(lastIndex) == c2) {
                        break;
                    }
                    --lastIndex;
                }
                end = lastIndex > end ? lastIndex : end;
                ++current;
            }
            ans.add((end - start + 1));
            start = end + 1;
        }
        return ans;
    }
}
