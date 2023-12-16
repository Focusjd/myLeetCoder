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

//给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。

//    public ListNode reverse(ListNode node){
//        ListNode curr = node, prev = null, next = null;
//        while (curr!=null){
//            next = curr.next;
//            curr.next = prev;
//            prev=curr;
//            curr=next;
//        }
//        return prev;
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
