import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int hardestWorker = logs[0][0], longestTime = logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int idx = logs[i][0];
            int duration = logs[i][1] - logs[i-1][1];
            if ((duration > longestTime) || (duration == longestTime && idx < hardestWorker)) {
                longestTime = duration;
                hardestWorker = idx;
            }
        }
        return hardestWorker;
    }
}
