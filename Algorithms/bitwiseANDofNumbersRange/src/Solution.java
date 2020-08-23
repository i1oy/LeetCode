/**
 * 解题思路1（失败）：
 *  依次循环处理[m, n]范围内的所有数字，返回最后结果。
 * 总结：范围较大的测试用例无法通过，提示"超出时间限制"。
 *
 * 解题思路2（官方题解）：
 *  将问题转化为求解给定数字的二进制字符串的公共前缀。
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).rangeBitwiseAnd(20000
                , 2147483647));
    }

    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        if (m == 0) return 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }

        return m << shift;
    }
}
