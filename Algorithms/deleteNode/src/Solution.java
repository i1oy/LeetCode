public class Solution {
    public static void main(String[] args) {
        Solution app = new Solution();
        ListNode listNode = app.createList(new int[]{1,2,3,4});
        ListNode listNode2 = app.createList(new int[]{0,1,});
        ListNode listNode3 = app.createList(new int[]{-3,5, -99});
        app.deleteNode(listNode.get(2));
        System.out.println(listNode);

        app.deleteNode(listNode2.get(0));
        System.out.println(listNode2);

        app.deleteNode(listNode3.get(0));
        System.out.println(listNode3);

    }
    // 官方题解
    // public void deleteNode(ListNode node) {
    //     node.val = node.next.val;
    //     node.next = node.next.next;
    // }

    public void deleteNode(ListNode node) {
        ListNode current = node;
        while (current.next != null) {
            current.val = current.next.val;
            if (current.next.next == null) {
                current.next = null;
            } else {
                current = current.next;
            }
        }
    }

    private ListNode createList(int[] arr) {
        ListNode node = new ListNode(arr[0]);
        ListNode current = node;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return node;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

     public ListNode get(int index) {
          ListNode current = this;
         for (int i = 0; i < index; i++) {
             if (current != null) current = current.next;
         }
          return current;
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