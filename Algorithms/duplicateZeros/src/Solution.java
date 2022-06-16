import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * 解题思路：
     *  使用正反方向两次遍历，实现原地修改；
     *  第一次正向遍历统计 0 的个数 count，得到如果全部复写 0 ，数组将延长多少位（即偏移量）；
     *  第二次反向遍历，当 i + count 进入数组长度范围内，根据偏移量覆盖元素值，
     *      遇到 arr[i] = 0 时，覆盖2次，并 --count.
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        int count = 0;
        for (int num : arr) if (num == 0) ++count;

        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            int num = arr[i];
            if (num == 0) {
                if (i + count < len && i + count >= 0) arr[i + count] = 0;
                if (i + count - 1 < len && i + count - 1 >= 0) arr[i + count - 1] = 0;
                --count;
            } else if (i + count < len && i + count >= 0) arr[i + count] = arr[i];
        }
    }
}
