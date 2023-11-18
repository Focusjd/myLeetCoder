

public class ReversListInterval {
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (head.next==null || m ==n){
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode start = dummyNode;
        for (int i = 0; i < m-1; i++) {
            start =start.next;
        }
        ListNode curr = start.next;
        ListNode pointer = curr.next;
        for (int i = 0; i < n-m; i++) {
            curr.next = pointer.next;
            pointer.next=start.next;
            start.next = pointer;
            pointer=curr.next;
        }
        return dummyNode.next;
    }

}
