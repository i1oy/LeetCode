
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode current = root;
        current.right = new TreeNode(2);
        current = current.right;
        current.left = new TreeNode(3);
        System.out.println(app.inorderTraversal(root));

        root = new TreeNode(4);
        current = root;
        current.left = new TreeNode(2);
        current = current.left;
        current.left = new TreeNode(1);
        current.right = new TreeNode(3);
        current = root;
        current.right = new TreeNode(7);
        current = current.right;
        current.left = new TreeNode(5);
        current = current.left;
        current.right = new TreeNode(6);
        System.out.println(app.inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        while (root != null || !nodeStack.isEmpty()) {
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }

            root = nodeStack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}
