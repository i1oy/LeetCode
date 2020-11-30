import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.reorganizeString("vvvlo"));
    }

    public String reorganizeString(String S) {
        int len = S.length();
        if (len < 2) return S;

        int[] counts = new int[26];
        int maxCount = 0;
        for (char c : S.toCharArray()) {
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (len + 1) / 2) return "";

        PriorityQueue<Character> queue = new PriorityQueue<>(
                new Comparator<Character>() {
                    @Override
                    public int compare(Character o1, Character o2) {
                        return counts[o2 - 'a'] - counts[o1 - 'a'];
                    }
                }
        );

        for (char c = 'a'; c <= 'z'; ++c) {
            if (counts[c - 'a'] > 0) queue.offer(c);
        }
        StringBuilder ans = new StringBuilder();
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            ans.append(letter1);
            ans.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0)
                queue.offer(letter1);
            if (counts[index2] > 0)
                queue.offer(letter2);
        }
        if (queue.size() > 0)
            ans.append(queue.poll());
        return ans.toString();
    }
}
