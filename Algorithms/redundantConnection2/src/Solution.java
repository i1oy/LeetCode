import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 解题思路： 题目中N个节点具有N条边，按照解题要求去掉一条边后， 除了根节点外，其他节点都有一个入度， 即所有节点中0入度节点1个，1入度节点N-1个。
 * 
 * 从后向前遍历每条边，考虑去掉某条边后的可能性： 1. 统计每个节点的入度，未满足要求的情况，则跳过； 2.
 * 对于符合节点入度的情况，检查从根节点（入度为0的节点） 到其他节点的连通性。
 */

class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();

        // [4, 2]
        System.out.println(Arrays.toString(
                app.findRedundantDirectedConnection(new int[][] { { 4, 2 }, { 1, 5 }, { 5, 2 }, { 5, 3 }, { 2, 4 } })));

        // [4, 1]
        System.out.println(Arrays.toString(
                app.findRedundantDirectedConnection(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 }, { 1, 5 } })));

        // [3, 1]
        System.out.println(Arrays.toString(
                app.findRedundantDirectedConnection(new int[][] { { 5, 2 }, { 5, 1 }, { 3, 1 }, { 3, 4 }, { 3, 5 } })));

        // [2, 3]
        System.out.println(
                Arrays.toString(app.findRedundantDirectedConnection(new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } })));

        // [2, 1]
        System.out.println(Arrays
                .toString(app.findRedundantDirectedConnection(new int[][] { { 2, 1 }, { 3, 1 }, { 4, 2 }, { 1, 4 } })));
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] ans = new int[2];
        int nodeCount = edges.length;

        boolean found = false;
        for (int i = edges.length - 1; i >= 0; --i) {
            ans[0] = edges[i][0];
            ans[1] = edges[i][1];

            int[] inDegree = new int[nodeCount + 1];

            for (int[] edge : edges) {
                int end = edge[1];
                if (edge[0] == ans[0] && edge[1] == ans[1]) {
                    continue;
                }
                inDegree[end]++;
            }

            int zeroInDeg = 0, twoInDeg = 0;
            int zeroInDegNode = -1;
            for (int n = 1; n < nodeCount + 1; ++n) {
                int deg = inDegree[n];
                if (deg == 0) {
                    zeroInDeg++;
                    zeroInDegNode = n;
                }
                if (deg >= 2) {
                    twoInDeg++;
                    break;
                }
            }
            if (zeroInDeg == 1 && twoInDeg == 0) {
                Stack<Integer> nodeStack = new Stack<>();
                Set<Integer> visited = new HashSet<>();
                nodeStack.push(zeroInDegNode);
                while (!nodeStack.isEmpty()) {
                    int current = nodeStack.pop();
                    visited.add(current);
                    for (int[] edge : edges) {
                        if (edge[0] == ans[0] && edge[1] == ans[1])
                            continue;
                        if (edge[0] == current && !visited.contains(edge[1])) {
                            nodeStack.push(edge[1]);
                        }
                    }
                }
                if (visited.size() == nodeCount)
                    found = true;
            }
            if (found)
                break;
        }
        return ans;
    }
}