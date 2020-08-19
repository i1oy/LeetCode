/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * 解题思路:
 *  获取链表的中间节点，作为BST的根节点；递归创建根节点的子树。
 * 总结：
 *  分治的处理思路基本正确；但是获取中间节点的方式太矬。
 *  优化方式：链表转化为数组、快慢指针
 */
class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int[] numbs = {-10, -3, 0, 5, 9};
        for (int n : numbs) {
            current.next = new ListNode(n);
            current = current.next;
        }
        Solution app = new Solution();
        TreeNode res = app.sortedListToBST(head.next);
        System.out.println(res.val);

    }

    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            ++size;
            current = current.next;
        }
        System.out.println(size);

        return createBinaryTree(head, 0, size);
    }

    private TreeNode createBinaryTree(ListNode head, int left, int right) {
        TreeNode node = null;
        if (left == right) return null;
        int mid = left + (right - left) / 2;
        int count = 0;
        ListNode current = head;
        while (count < mid) {
            current = current.next;
            ++count;
        }

        node = new TreeNode(current.val);

        node.left = createBinaryTree(head, left, mid);
        node.right = createBinaryTree(head, mid + 1, right);
        return node;
    }

}