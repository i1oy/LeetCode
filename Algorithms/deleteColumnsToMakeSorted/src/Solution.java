public class Solution {
    /**
     * 944. Delete Columns to Make Sorted
     * @param strs
     * @return
     */
    public int minDeletionSize(String[] strs) {
        int ans = 0;
        int n = strs[0].length(), len = strs.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j < len; ++j) {
                if (strs[j].charAt(i) - strs[j - 1].charAt(i) < 0) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
