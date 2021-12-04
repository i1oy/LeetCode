import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(
                app.largestSumAfterKNegations(new int[]{-4, 4, -3, 3, -4, -1, 8, -7, -7}, 3)
        );
        System.out.println(
                app.largestSumAfterKNegations(new int[]{4, 2, 3}, 1)
        );
        System.out.println(
                app.largestSumAfterKNegations(new int[]{3, -1, 0, 2,}, 3)
        );
        System.out.println(
                app.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4,}, 2)
        );
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0, len = nums.length;
        List<Integer> negativeNums = new ArrayList<>();
        int minAbsoluteVal = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (Math.abs(minAbsoluteVal) > Math.abs(num)) {
                if (i != 0) {
                    if (minAbsoluteVal > 0) sum += minAbsoluteVal;
                    else negativeNums.add(minAbsoluteVal);
                }
                minAbsoluteVal = num;
            } else {
                if (num > 0) sum += num;
                else negativeNums.add(num);
            }
        }
        Collections.sort(negativeNums, Integer::compareTo);
        int index = 0;
        int negativeNumsLen = negativeNums.size();
        int end = Math.min(k, negativeNumsLen);
        int temp = 0;
        while (index < end) {
            --k;
            temp += negativeNums.get(index++);
        }
        sum += temp * (-1);
        if (index < negativeNumsLen) {
            for (int i = index; i < negativeNumsLen; i++) sum += negativeNums.get(i);
            sum += minAbsoluteVal;
        } else sum += (minAbsoluteVal * (k % 2 == 1 ? -1 : 1));
        return sum;
    }
}
