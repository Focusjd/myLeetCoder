
//将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
//如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
//你不能更改节点中的值，只能更改节点本身。

public class ReversListbyGroup {
//    将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
//如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
//你不能更改节点中的值，只能更改节点本身。
// Medium    time O(n), space O(1)
    public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null || head.next ==null || k==1) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode curr = head;
        ListNode pointer = head.next;
        ListNode checker = dummyNode.next;
        for (int i = 0; i < k; i++) {
            if (checker==null) return dummyNode.next;
            checker = checker.next;
        }

        while (pointer!=null){
            for (int i = 0; i < k - 1; i++) {
                curr.next = pointer.next;
                pointer.next=pre.next;
                pre.next=pointer;
                pointer=curr.next;
                if (checker!=null) checker=checker.next;
            }
            if (checker!=null) checker=checker.next;
            if (checker==null) return dummyNode.next;

            ListNode temp = curr;
            curr = pointer;
            pointer = curr.next;
            pre = temp;
        }

        return dummyNode.next;
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//    if (head == null || head.next == null || k == 1) {
//        return head;
//    }
//
//    ListNode dummyNode = new ListNode(-1);
//    dummyNode.next = head;
//
//    ListNode pre = dummyNode;
//    ListNode curr = head;
//
//    while (curr != null) {
//        ListNode checker = curr;
//        for (int i = 0; i < k; i++) {
//            if (checker == null) return dummyNode.next;
//            checker = checker.next;
//        }
//
//        ListNode nextGroupHead = curr;
//        for (int i = 0; i < k - 1; i++) {
//            ListNode pointer = curr.next;
//            curr.next = pointer.next;
//            pointer.next = pre.next;
//            pre.next = pointer;
//        }
//
//        pre = nextGroupHead;
//        curr = nextGroupHead.next;
//    }
//
//    return dummyNode.next;
//}
    public ListNode reverse(ListNode head){
        ListNode curr =  head, prev=  null, next = null;
        while(curr!=null){
            next  =  curr.next;
            curr.next =  prev ;
            prev =  curr;
            curr  =  next;
        }
        return prev;
    }
}
