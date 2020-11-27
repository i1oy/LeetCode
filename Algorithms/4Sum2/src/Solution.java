import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2}
        ));
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ans = 0;
        Map<Integer, Integer> sumAB = new HashMap<>();
        for (int a : A)
            for (int b : B)
                sumAB.put(a + b, sumAB.getOrDefault(a + b, 0) + 1);

        for (int c : C)
            for (int d : D)
                ans += sumAB.getOrDefault(-c - d, 0);
        return ans;
    }
}