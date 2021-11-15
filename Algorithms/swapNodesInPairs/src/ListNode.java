public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.val);
        ListNode current = this.next;
        while (current != null) {
            stringBuilder.append("->");
            stringBuilder.append(current.val);
            current = current.next;
        }
        return stringBuilder.toString();
    }
}
