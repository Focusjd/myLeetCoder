import java.util.List;

public class MergeList {
    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) {
            return pHead2;
        } else if (pHead2 == null) {
            return pHead1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode prev = dummyNode;

        while (pHead1!=null && pHead2!=null){
            if(pHead1.val< pHead2.val){
                prev.next=pHead1;
                prev = prev.next;
                pHead1 = pHead1.next;
            }else {
                prev.next=pHead2;
                prev = prev.next;
                pHead2 = pHead2.next;
            }
        }
        prev.next = pHead1==null ? pHead2 :pHead1;

        return dummyNode.next;
    }


}
