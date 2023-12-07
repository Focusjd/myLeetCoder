import java.util.List;

public class MyListNode {

    public ListNode FindKthToTail (ListNode pHead, int k) {

        ListNode pointer = pHead;
        for (int i = 0; i < k; i++) {
            if (pointer == null) return null; //还需要执行但是已经到头
            pointer = pointer.next;
        }

        while (pointer!=null){
            pointer = pointer.next;
            pHead = pHead.next;
        }
        return pHead;
    }

//给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode fast = head;
        ListNode prev = dummyNode;

        for (int i = 0; i < n; i++) { // 快慢指针执行的次数
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            head = head.next;
            prev = prev.next;
        }

        prev.next = head.next;
        return dummyNode.next;
    }

//    给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
//注意是节点的编号而非节点的数值。
    public ListNode oddEvenList (ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenHead = new ListNode(-2);
        ListNode oddHead = new ListNode(-1);
        oddHead.next = head;
        evenHead.next = head.next;

        ListNode even = evenHead;
        ListNode odd = oddHead;

        ListNode pointer = head;

        int index = 1;
        while (pointer != null){
            System.out.println(pointer.val);
            if (index %2 ==1){
                odd.next = pointer;
                odd = pointer;
            }else {
                even.next = pointer;
                even = pointer;
            }
            pointer = pointer.next;
            index++;
        }
        odd.next = evenHead.next;
        return oddHead.next;
    }

}
