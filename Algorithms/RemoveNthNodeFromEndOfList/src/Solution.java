public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        int[] nodes = new int[]{
                1, 2
        };
        ListNode head = new ListNode();
        ListNode current = head;
        for (int node : nodes) {
            current.next = new ListNode(node);
            current = current.next;
        }
        ListNode res = app.removeNthFromEnd(head.next, 2);
        String separator = "";
        while (res != null) {
            System.out.printf("%s%d", separator, res.getVal());
            separator = " -> ";
            res = res.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head, forward = head, prev = null;
        int count = 1;
        while (count < n) {
            forward = forward.next;
            ++count;
        }

        if (forward.next == null) {
            head = head.next;
        } else {
            while (forward.next != null) {
                forward = forward.next;
                prev = current;
                current = current.next;
            }
            if (prev != null)
                prev.next = current.next;
        }
        return head;
    }

}
