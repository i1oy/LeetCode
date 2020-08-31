import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 解题思路：
 *  深度优先遍历所有可打开的房间，检查已访问的房间数是否与所有房间数一致。
 */

class Solution {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new LinkedList<>();
        List<Integer> room0 = Arrays.asList(new Integer[]{1, 3});
        List<Integer> room1 = Arrays.asList(new Integer[]{3, 0, 1});
        List<Integer> room2 = Arrays.asList(new Integer[]{2});
        List<Integer> room3 = Arrays.asList(new Integer[]{0});
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        Solution app = new Solution();
        System.out.println(app.canVisitAllRooms(rooms));
    }

    List<Integer> visitedRooms = new ArrayList<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(rooms, 0);
        return rooms.size() == visitedRooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int roomKey) {
        if (visitedRooms.contains(roomKey)) return;
        visitedRooms.add(roomKey);
        for (int k : rooms.get(roomKey)) {
            dfs(rooms, k);
        }
    }
}