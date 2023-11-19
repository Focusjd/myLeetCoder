
//将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度O(n),空间O(1)
public class ReversListInterval {
//    public ListNode reverseBetween (ListNode head, int m, int n) {
//        if (head == null) {
//            return null;
//        }
//        if (head.next==null || m ==n){
//            return head;
//        }
//        ListNode dummyNode = new ListNode(-1);
//        dummyNode.next = head;
//
//        ListNode start = dummyNode;
//        for (int i = 0; i < m-1; i++) {
//            start =start.next;
//        }
//        ListNode curr = start.next;
//        ListNode pointer = curr.next;
//        for (int i = 0; i < n-m; i++) {
//            curr.next = pointer.next;
//            pointer.next=start.next;
//            start.next = pointer;
//            pointer=curr.next;
//        }
//        return dummyNode.next;
//    }
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (head.next==null || m ==n){
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode startPre = dummyNode;
        for (int i = 0; i < m-1; i++) {
            startPre = startPre.next;
        }
        startPre.next = reverse(startPre.next, n-m+1);


        return dummyNode.next;
    }
    public ListNode reverse(ListNode node, int num){
        ListNode prev = null, curr = node, next = null;
        for (int i = 0; i < num; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node.next = next;

        return prev;
    }

}
