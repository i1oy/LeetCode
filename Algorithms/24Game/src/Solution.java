import java.util.ArrayList;
import java.util.List;

public class Solution {
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double)num);
        }
        return solve(list);
    }

    private boolean solve(List<Double> list) {
        int size = list.size();
        if (size == 0) return false;
        if (size == 1) return Math.abs(list.get(0) - TARGET) < EPSILON;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (i == j) continue;
                List<Double> list2 = new ArrayList<>();
                for (int k = 0; k < size; ++k) {
                    if (k == i || k == j) continue;
                    list2.add(list.get(k));
                }
                for (int k = 0; k < 4; ++k) {
                    if (k < 2 && i > j) continue;
                    if (k == ADD) {
                        list2.add(list.get(i) + list.get(j));
                    } else if (k == MULTIPLY) {
                        list2.add(list.get(i) * list.get(j));
                    } else if (k == SUBTRACT) {
                        list2.add(list.get(i) - list.get(j));
                    } else if (k == DIVIDE) {
                        if (Math.abs(list.get(j)) < EPSILON) continue;
                        else {
                            list2.add(list.get(i) / list.get(j));
                        }
                    }
                    if (solve(list2)) return true;
                    list2.remove(list2.size() - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 8, 7};
        Solution app = new Solution();
        System.out.println(app.judgePoint24(nums));
    }
}
