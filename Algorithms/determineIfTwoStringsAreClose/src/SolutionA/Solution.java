package SolutionA;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        // System.out.println(app.closeStrings("cabbba", "aabbss"));
        // System.out.println(app.closeStrings("abbzzca", "babzzcz"));
        // System.out.println(app.closeStrings("abc", "bca"));
        System.out.println(app.closeStrings("a", "aa"));
        System.out.println(app.closeStrings("cabbba", "abbccc"));
        System.out.println(app.closeStrings("cab", "bca"));
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() == word2.length()) {
            int[] countsW1 = new int[26];
            int[] countsW2 = new int[26];
            for (char c : word1.toCharArray()) countsW1[c - 'a']++;
            for (char c : word2.toCharArray()) countsW2[c - 'a']++;
            for (int i = 0; i < 26; i++) {
                if ((countsW1[i] * countsW2[i]) == 0 &&
                        (countsW1[i] + countsW2[i]) != 0) {
                    return false;
                }
            }
            Arrays.sort(countsW1);
            Arrays.sort(countsW2);
            for (int i = 0; i < 26; i++) {
                if (countsW1[i] != countsW2[i]) return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
