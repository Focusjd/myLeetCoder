import jdk.jshell.Snippet;

import java.util.*;

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


//    给定一个链表，请判断该链表是否为回文结构。
    public boolean isPail (ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (fast != null){
            arrayList.add(fast.val);
            fast = fast.next;
        }

        for (int i = 0; i < arrayList.size() / 2; i++) {
            if (!Objects.equals(arrayList.get(i), arrayList.get(arrayList.size() - 1 - i)))
                return false;
        }
        return true;
    }

//    删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
//    Easy Time n Space n
//    public ListNode deleteDuplicates (ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode dummyNode = new ListNode(-1);
//        dummyNode.next = head;
//        HashSet<Integer> set = new HashSet<>();
//
//        ListNode prev = dummyNode;
//        while (head != null){
//            if (!set.contains(head.val)){
//                set.add(head.val);
//                head = head.next;
//                prev = prev.next;
//            }else {
//                head = head.next;
//                prev.next = head;
//            }
//        }
//        return dummyNode.next;
//    }


//    Time n Space 1

//    public ListNode deleteDuplicates (ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode dummyNode = new ListNode(-1);
//        dummyNode.next = head;
//
//        ListNode prev = dummyNode;
//        ListNode curr = head;
//        ListNode next = head.next;
//
//        while (next != null){
//            if (next.val == curr.val){
//                while (next != null && next.val == curr.val){
//                    next = next.next;
//                }
//                curr.next = next;
//                curr = next;
//            }else {
//                next = next.next;
//                curr = curr.next;
//            }
//        }
//
//        return dummyNode.next;
//    }
    public ListNode deleteDuplicates (ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode curr = head;

        while (curr != null && curr.next != null){
            if (curr.val == curr.next.val){
                while (curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                prev.next = null;
            }else {
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        if (curr != null && prev.val != curr.val){
            prev.next = curr;
        }

        return dummyNode.next;
    }

//    给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。


//    判断给定的链表中是否有环。如果有环则返回true，否则返回false。
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow){
            if (fast == null || fast.next ==null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }



//    给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
//    Medium Time n Space n
//    public ListNode EntryNodeOfLoop(ListNode pHead) {
//        HashSet<ListNode> hashSet = new HashSet<>();
//        while (pHead != null){
//            if (!hashSet.contains(pHead)){
//                hashSet.add(pHead);
//            }else {
//                break;
//            }
//            pHead = pHead.next;
//        }
//        return pHead;
//    }

//    Time n Space 1
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                break;
            }
        }

        if (fast == null || fast.next == null)
            return null;
        fast = pHead;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


//    假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
//给定两个这种链表，请生成代表两个整数相加值的结果链表。
//    public ListNode addInList (ListNode head1, ListNode head2) {
//
//    }







}
