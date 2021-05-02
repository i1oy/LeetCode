import java.util.*;

/**
 * [
 *  [1,2,2,1],
 *  [3,1,2],
 *  [1,3,2],
 *  [2,4],
 *  [3,1,2],
 *  [1,3,1,1]
 * ]
 * 由测试用例可知，砖墙的长度为6
 * 砖墙中间存在5条垂直的通道，
 * 依次遍历每层，计算垂直通道连通度；
 * 最后使用砖墙的高度减去垂直通道的最大连通度，即可得到穿过砖头数的最小值
 */
class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();

        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1));
        wall.add(Arrays.asList(1));
        wall.add(Arrays.asList(1));

        System.out.println(app.leastBricks(wall));
    }

    public int leastBricks(List<List<Integer>> wall) {
        int rows = wall.size();
        int res = rows;
        Map<Integer, Integer> ways = new HashMap<>();
        for (List<Integer> row : wall) {
            int current = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                current += row.get(i);
                ways.put(current, ways.getOrDefault(current, 0) + 1);
            }
        }

        for (int w : ways.values()) {
            res = res > rows - w ? rows - w : res;
        }
        return res;
    }
}