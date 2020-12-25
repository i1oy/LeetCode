import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        List<int[]> arrs = new ArrayList<>();
        arrs.add(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
        arrs.add(new int[]{4, 8, 12, 16});
        arrs.add(new int[]{100});
        Solution app = new Solution();
        for (int i = 0; i < arrs.size(); ++i) {
            int res = app.maxTurbulenceSize(arrs.get(i));
            System.out.println(res);

        }
    }

    /**
     * @param arr
     * @return
     */
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len < 2) return len;
        int res = 0;
        int left = 0, right = 0;
        while (right < len - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    ++left;
                }
                ++right;
            } else {
                if (arr[right] < arr[right - 1] && arr[right] < arr[right + 1]) {
                    ++right;
                } else if (arr[right] > arr[right - 1] && arr[right] > arr[right + 1]) {
                    ++right;
                } else {
                    left = right;
                }
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}