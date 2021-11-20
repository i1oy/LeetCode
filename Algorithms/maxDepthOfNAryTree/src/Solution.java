import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new ArrayList<>();

        Node first = new Node(3);
        Node second = new Node(2);
        Node third = new Node(4);
        first.children = new ArrayList<>();
        first.children.add(new Node(5));
        first.children.add(new Node(6));

        root.children.add(first);
        root.children.add(second);
        root.children.add(third);

        Solution app = new Solution();
        System.out.println(app.maxDepth(root));
    }
    public int maxDepth(Node root) {
        return dfs(root, 0);
    }

    private int dfs(Node node, int depth) {
        if (node == null) return depth;
        if (node.children == null) return depth + 1;
        int maxDepth = depth + 1;
        for (Node n : node.children) {
            maxDepth = Math.max(maxDepth, dfs(n, depth + 1));
        }
        return maxDepth;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node(int _val) {
        val = _val;
    }

}


