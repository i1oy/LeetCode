import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        int[] score = new int[]{
                10, 3, 8, 9, 4
        };
        String[] res = app.findRelativeRanks(score);
    }

    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        String[] MEDALS = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] ranks = new String[len];
        int[] sortedScore = new int[len];
        System.arraycopy(score, 0, sortedScore, 0, len);
        Arrays.sort(sortedScore);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) map.put(sortedScore[i], len - i);
        for (int i = 0; i < len; i++) {
            int rank = map.get(score[i]);
            ranks[i] = rank <=3 ? MEDALS[rank - 1] : String.valueOf(rank);
        }
        return ranks;
    }
}
