class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.sortString("rat"));
    }
    public String sortString(String s) {
        int len = s.length();
        int[] alph = new int[26];
        StringBuilder ans = new StringBuilder(len);

        for (char c : s.toCharArray()) {
            alph[c - 'a']++;
        }
        while (ans.length() < len) {
            for (int i = 0; i < 26; ++i) {
                if (alph[i] > 0) {
                    ans.append((char)(i + 'a'));
                    alph[i]--;
                }
            }
            for (int i = 25; i >= 0; --i) {
                if (alph[i] > 0) {
                    ans.append((char)(i + 'a'));
                    alph[i]--;
                }
            }
        }
        return ans.toString();
    }
}