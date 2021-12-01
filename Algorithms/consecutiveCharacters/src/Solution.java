public class Solution {
    public static void main(String[] args) {
        String[] strings = new String[]{
                "cc", "leetcode", "abbcccddddeeeeedcba",
                "triplepillooooow", "hooraaaaaaaaaaay",
                "tourist", "a",
        };

        Solution app = new Solution();
        for (String s : strings) {
            System.out.println(app.maxPower(s));
        }
    }

    public int maxPower(String s) {
        int res = 0, count = 0;
        char c = 0;
        for (char x : s.toCharArray()) {
            if (x != c) {
                res = res > count ? res : count;
                count = 1;
                c = x;
            } else {
                ++count;
            }

        }
        return res > count ? res : count;
    }
}
