class Solution {

    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.closeStrings("cabbba", "abbccc"));
    }
    public boolean closeStrings(String word1, String word2) {
        char[] dict1 = new char[26];
        char[] dict2 = new char[26];

        for (Character c : word1.toCharArray()) dict1[c - 'a']++;
        for (Character c : word2.toCharArray()) dict2[c - 'a']++;

        for (int i = 0; i < 26; ++i) {
            if ((dict1[i] * dict2[i]) == 0 && (dict1[i] + dict2[i]) != 0) return false;
        }

        for (int i = 0; i < 26; ++i) {
            boolean flag = false;
            for (int j = 0; j < 26; ++j) {
                if (dict2[j] == dict1[i]) {
                    dict2[j] = 0;
                    flag = true;
                    break;
                }
            }
            if (!flag) return false;
            if (i == 25) return true;
        }
        return false;
    }
}