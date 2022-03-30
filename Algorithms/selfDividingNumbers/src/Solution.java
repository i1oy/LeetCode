import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        for (int n : app.selfDividingNumbers(1, 22)) {
            System.out.println(n);
        }

        for (int n : app.selfDividingNumbers(47, 85)) {
            System.out.println(n);
        }
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        int current = left;
        while (current <= right) {
            if (isSelfDividingNum(current)) res.add(current);
            current++;
        }
        return res;
    }

    private boolean isSelfDividingNum(int num) {
        if (num < 10) return true;
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit != 0 && num % digit == 0) {
                temp /= 10;
                continue;
            } else return false;
        }
        return true;
    }
}
