import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        int[] nodes = new int[]{
                1, 2, 3, 4, 5
        };
        ListNode listNode = new ListNode();
        ListNode current = listNode;
        for (int n : nodes) {
            current.next = new ListNode(n);
            current = current.next;
        }
        app.reorderList(listNode.next);
        current = listNode.next;
        String separator = "";
        while (current != null) {
            System.out.printf("%s%d", separator,current.val);
            current = current.next;
            separator = "->";
        }

    }

    public void reorderList(ListNode head) {
        if (head == null) return;

        List<ListNode> listNodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            listNodes.add(current);
            current = current.next;
        }

        current = head;
        int len = listNodes.size();
        for (int i = 0; i < (len >> 1); ++i) {
            ListNode node = listNodes.get(i);
            ListNode node2 = listNodes.get(len - 1 - i);
            node.next = node2;
            if ((i + 1) != (len - 1 - i)) {
                node2.next = listNodes.get(i + 1);
            }
        }
        listNodes.get(len >> 1).next = null;
    }

}