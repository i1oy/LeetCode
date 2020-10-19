import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(
                app.backspaceCompare("ab#c", "ad#c")
        );
    }
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> characters = new Stack<>();
        Stack<Character> characters2 = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (characters.isEmpty()) continue;
                characters.pop();
            } else {
                characters.push(c);
            }
        }

        for (char c : T.toCharArray()) {
            if (c == '#') {
                if (characters2.isEmpty()) continue;
                characters2.pop();
            } else {
                characters2.push(c);
            }
        }

        if (characters.size() != characters2.size()) return false;

        while (!characters.isEmpty() && !characters2.isEmpty()) {
            if (characters.pop() == characters2.pop()) continue;
            return false;
        }
        return true;
    }
}