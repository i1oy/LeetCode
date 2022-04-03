public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.nextGreatestLetter(new char[]{'a', 'b'}, 'z'));
        System.out.println(app.nextG(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(app.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(app.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println(app.nextG(new char[]{'c', 'f', 'j'}, 'z'));
        System.out.println(app.nextG(new char[]{'e','e','e','e','e','e','n','n','n','n'}, 'z'));
    }

    /**
     * 744. Find Smallest Letter Greater Than Target
     * 解题思路：暴力解法；
     * 另一解题思路：二分法
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters) if (c > target) return c;
        return letters[0];
    }

    private char nextGreatestLetter2(char[] letters, char target) {
        int len = letters.length, left = 0, right = len - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (letters[mid] > target) right = mid;
            else left = mid + 1;
        }
        return target < letters[right] ? letters[right] : letters[0];
    }
}
