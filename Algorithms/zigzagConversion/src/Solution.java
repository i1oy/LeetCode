class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.convert("PAYPALISHIRING", 3));
    }

    // 6. ZigZag Conversion
    public String convert(String s, int numRows) {
        int len = s.length(), r = numRows;
        if (r == 1 || len <= r) return s;
        // 从上到下，再从下到右上的路径，视为一个周期
        int cycle = r * 2 - 2;
        // 计算周期的个数（最后一个周期视为完整周期），
        // 乘上每个周期的列数，得到整个矩阵的列数
        int c = (len + cycle - 1) / cycle * (r - 1);
        char[][] matrix = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < len; ++i) {
            matrix[x][y] = s.charAt(i);
            if (i % cycle < r - 1) ++x;
            else {
                --x;
                ++y;
            }
        }
        StringBuilder ans = new StringBuilder(len);
        for (char[] row : matrix) {
            for (char ch : row) if (ch != 0) ans.append(ch);
        }
        return ans.toString();
    }
}