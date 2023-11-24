
//链表题两个关键
//1) dummyNode
//2) 两个或者三个关键指针, prev,curr,next
//遍历链表用 while (curr!=null)
//每个循环起点可以prev和curr指向同一位置，循环不易指向null
public class DeleteNode {
//    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
//    例如，链表 1->2->3->3->4->4->5  处理后为 1->2->5

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummyNode = new ListNode(0 );
        dummyNode.next = pHead;

        ListNode prev = dummyNode;
        ListNode curr = pHead;
        ListNode next = pHead;

        while (curr!=null){
            next = curr.next;
            if (next == null) break;
            if (next.val == curr.val){
                while (next != null && next.val == curr.val){
                    next = next.next;
                }
                curr = next;
                prev.next = curr;
            }
            else {
                prev = curr;
                curr = next;
            }
        }

        return dummyNode.next;
    }


//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
//1.此题对比原题有改动
//2.题目保证链表中节点的值互不相同
//3.该题只会输出返回的链表和结果做对比，所以若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
//    Easy Time n, Space 1

    public ListNode deleteNode (ListNode head, int val) {
        ListNode dummyNode  = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode curr = head;
        while (curr != null){
            if (curr.val == val){
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return dummyNode.next;
    }


//    public ListNode deleteNode (ListNode head, int val) {
//        if (head == null) {
//            return null;
//        }
//        if (head.val == val) return head.next;
//        if (head.next == null) return head;
//        ListNode dummyNode = new ListNode(-1);
//        dummyNode.next = head;
//        while (head.next.val!=val){ // 不建议使用，无法处理链表中缺少这个元素的情况
//            head = head.next;
//        }
//        head.next = head.next.next;
//
//        return dummyNode.next;
//    }
}
