
class ListNode {
  int val;
  ListNode next = null;
  public ListNode(int val) {
    this.val = val;
  }
}


public class ReverseList {


    // public ListNode ReverseList (ListNode head) {
    //     if (head == null) {
    //         return null;
    //     }
    //     ListNode newTail = new ListNode(head.val);
    //     while (head.next!=null){
    //         head=head.next;
    //         ListNode temp = new ListNode(head.val);
    //         temp.next = newTail;
    //         newTail = temp;

    //     }
    //     return newTail;
    // }
    // public ListNode ReverseList (ListNode head) {
    //     if (head == null) {
    //         return null;
    //     }
    //     ListNode current = head;
    //     ListNode previous = null;
    //     ListNode next = null;
    //     while (current!=null){
    //         next = current.next;
    //         current.next = previous;
    //         previous = current;
    //         current = next;
    //     }


    //     return previous;
    // }
    public ListNode ReverseList (ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode curr = head;
        ListNode next = head.next;
        while (next!=null){
            curr.next=next.next;
            next.next=pre.next;
            pre.next= next;
            next = curr.next;
        }
        return dummyNode.next;
    }
}
