import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        List<String> res = app.letterCombinations("999");
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        int len = digits.length();
        if (len == 0) return ans;

        Map<Character, List<Character>> digitLetters = initDigitLetters();
        ans.add("");
        for (int i = 0; i < len; ++i) {
            char c = digits.charAt(i);
            List<String> temp = (List<String>) ((ArrayList<String>) ans).clone();
            ans.clear();
            List<Character> letters = digitLetters.get(c);
            for (Character letter : letters) {
                for (String str : temp) {
                    ans.add(str + letter.toString());
                }
            }
        }
        return ans;
    }

    private Map<Character, List<Character>> initDigitLetters() {
        Map<Character, List<Character>> res = new HashMap<>();
        Character[] lettersOf2 = {'a', 'b', 'c'};
        Character[] lettersOf3 = {'d', 'e', 'f'};
        Character[] lettersOf4 = {'g', 'h', 'i'};
        Character[] lettersOf5 = {'j', 'k', 'l'};
        Character[] lettersOf6 = {'m', 'n', 'o'};
        Character[] lettersOf7 = {'p', 'q', 'r', 's'};
        Character[] lettersOf8 = {'t', 'u', 'v'};
        Character[] lettersOf9 = {'w', 'x', 'y', 'z'};
        res.put('2', Arrays.asList(lettersOf2));
        res.put('3', Arrays.asList(lettersOf3));
        res.put('4', Arrays.asList(lettersOf4));
        res.put('5', Arrays.asList(lettersOf5));
        res.put('6', Arrays.asList(lettersOf6));
        res.put('7', Arrays.asList(lettersOf7));
        res.put('8', Arrays.asList(lettersOf8));
        res.put('9', Arrays.asList(lettersOf9));
        return res;
    }
}
