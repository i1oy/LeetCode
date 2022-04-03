public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.nextGreatestLetter(new char[]{'a', 'b'}, 'z'));
        System.out.println(app.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(app.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(app.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
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

}
