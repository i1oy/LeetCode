import java.util.*;

public class Solution {
    /**
     * 735. Asteroid Collision
     * @param asteroids
     * @return
     * 解题思路：
     *  使用栈来解题；注意细节。
     */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (deque.isEmpty()) deque.push(asteroid);
            else {
                if (asteroid * deque.peek() > 0 || deque.peek() < 0) deque.push(asteroid);
                else {
                    boolean exists = true;
                    while (!deque.isEmpty()) {
                        int current = deque.peek();
                        if (current * asteroid > 0) break;
                        int diff = Math.abs(current) - Math.abs(asteroid);
                        if (diff > 0) {
                            exists = false;
                            break;
                        } else if (diff == 0) {
                            exists = false;
                            deque.pop();
                            break;
                        } else deque.pop();
                    }
                    if (exists) deque.push(asteroid);
                }
            }
        }
        int[] res = new int[deque.size()];
        for (int i = 0; i < res.length; i++) res[i] = deque.pollLast();
        return res;
    }
}
