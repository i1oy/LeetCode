import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        int[][] intervals = new int[][]{
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        };
        int[] newInterval = new int[]{4, 8};
        System.out.println(
                Arrays.deepToString(app.insert(intervals, newInterval))
        );

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int left = newInterval[0], right = newInterval[1];
        boolean placed = false;
        int i = 0, len = intervals.length;
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!placed) {
                    placed = true;
                    res.add(new int[]{left, right});
                }
                res.add(interval);
            } else if (interval[1] < left) {
                res.add(interval);
            } else {
                left = left < interval[0] ? left : interval[0];
                right = right > interval[1] ? right : interval[1];
            }
        }
        if (!placed) {
            res.add(new int[]{left, right});
        }
        int[][] ans = new int[res.size()][2];
        int index = 0;
        for (int[] arr : res) {
            ans[index][0] = arr[0];
            ans[index][1] = arr[1];
            ++index;
        }
        return ans;
    }
}
