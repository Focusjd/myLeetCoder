public class FirstCommonListNode {
//    输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。
//    思路1：从两个剩余长度相等的位置连续比较，则一定会遇到同一个节点，所以先使长的链表往前走直到剩余长度相等 （不推荐，推荐思路2）
//    Easy Time n Space 1
//    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//        ListNode target = null;
//        int length1 = findListLength(pHead1);
//        int length2 =  findListLength(pHead2);
//        int step = Math.abs(length2 - length1);
//        if (length1>length2){
//            while(step-- >0){
//                pHead1 = pHead1.next;
//            }
//        }else {
//            while (step-- >0){
//                pHead2 = pHead2.next;
//            }
//        }
//
//        while (pHead1!=null && pHead2!=null){
//            if (pHead1.val == pHead2.val){
//                target = pHead1;
//                break;
//            }
//            pHead1 = pHead1.next;
//            pHead2 = pHead2.next;
//        }
//
//        return target;
//    }
//    public int findListLength(ListNode head){
//        int length = 0;
//        while (head!=null){
//            head = head.next;
//            length++;
//        }
//        return length;
//    }
//    思路2: 同时遍历两个链表，到结尾交换当前指针的遍历的链表，两个指针相遇则到达公共节点。
//    Easy Time n Space 1
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //设置两个节点head1和和head2,将两个节点分别位于两个链表头结点处
        ListNode head1=pHead1;
        ListNode head2=pHead2;
        //同时出发，一起向相应的链表的后面进行遍历，当两个节点位于同一地址的时候，就是两个链表的第一个公共节点
        //但是如果发现head1已经遍历完链表1,就让它从pHead2开始遍历链表2
        //同理：如果head2已经遍历完链表2，就让它从pHead1开始遍历链表1
        //由于它们是同时出发的，所以到相遇的时候经过的时间是一样的，又因为速度也是一样的，所以最后相遇的时候经过的总路程是一样的，而由于是两个表交错着走，所以最后路程一样的位置就是两个链表的两个链表的公共节点
        //如果没有公共节点，随后head1和head2都会走到null,此时head1==head2，会退出循环，返回null
        while(head1!=head2){
            if(head1==null){ //判断条件不是 pHead1.next是需要考虑他们永远也不会相遇的情况
                head1=pHead2;
            }else{
                head1=head1.next;
            }
            if(head2==null){
                head2=pHead1;
            }else{
                head2=head2.next;
            }

        }
        return head1;
    }

}
