import java.util.ArrayList;
import java.util.Stack;

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
//    public ListNode ReverseList (ListNode head) {
//        if (head == null) {
//            return null;
//        } else if (head.next == null) {
//            return head;
//        }
//        ListNode dummyNode = new ListNode(-1);
//        dummyNode.next = head;
//
//        ListNode pre = dummyNode;
//        ListNode curr = head;
//        ListNode next = head.next;
//        while (next!=null){
//            curr.next=next.next;
//            next.next=pre.next;
//            pre.next= next;
//            next = curr.next;
//        }
//        return dummyNode.next;
//    }
    public ListNode ReverseList (ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        return reverse(head);

    }

//    reverse 都是从后向前，先记住最深层的节点（next），从右向左从上到下
    public ListNode reverse(ListNode node){
        ListNode curr = node, prev = null, next = null;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

//输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
//    EASY Time: 2n Space: n
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> res = new ArrayList<>();
//        if (listNode == null) {
//            return res;
//        }
//        ListNode dummyNode = new ListNode(0);
//        dummyNode.next = listNode;
//        ListNode prev = null;
//        ListNode curr = dummyNode;
//        ListNode next = null;
//
//        while (curr!=null){
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//
//        while (prev!=dummyNode){
//            res.add(prev.val);
//            prev = prev.next;
//        }
//        return res;
//    }
//Time n Space n
//    using stack
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (stack.empty()){
            res.add(stack.pop());
        }

        return res;
    }


}
