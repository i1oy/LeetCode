class Solution {
    /**
     * 2351. First Letter to Appear Twice
     * @param s
     * @return
     */
    public char repeatedCharacter(String s) {
        char[] records = new char[26];
        for (char c : s.toCharArray()) {
            if(++records[c - 'a'] > 1)
                return c;
        }
        return 0;
    }
}