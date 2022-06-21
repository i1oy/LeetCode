import java.util.LinkedList;
import java.util.List;

public class Solution {
    int ans = 0;

    /**
     * 解题思路：
     *  按层遍历，找到最底层最左边的节点即可。
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> treeNodeList = new LinkedList<>();
        treeNodeList.add(root);
        findByLevelOrder(treeNodeList);
        return ans;
    }

    void findByLevelOrder(List<TreeNode> treeNodeList) {
        if (treeNodeList.size() > 0) {
            ans = treeNodeList.get(0).val;
            List<TreeNode> currentLevel = new LinkedList<>();
            while (treeNodeList.size() > 0) {
                TreeNode node = treeNodeList.remove(0);
                if (node.left != null) currentLevel.add(node.left);
                if (node.right != null) currentLevel.add(node.right);
            }
            findByLevelOrder(currentLevel);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
