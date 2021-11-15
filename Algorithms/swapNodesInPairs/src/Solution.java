public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;
        ListNode third = new ListNode(3);
        second.next = third;
        ListNode forth = new ListNode(4);
        third.next = forth;
        ListNode newHead = app.swapPairs(first);
        System.out.println(newHead);
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head.next;
        head.next = swapPairs(current.next);
        current.next = head;
        return current;
    }
}
