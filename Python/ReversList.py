class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        if not head or m == n or not head.next:
            return head

        dummy_node = ListNode(-1)
        dummy_node.next = head

        start = dummy_node

        for i in range(0, m - 1):
            start = start.next

        prev = None
        curr = start.next
        next = None
        start_next = curr

        for i in range(0, n - m + 1):
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next

        start.next = prev
        start_next.next = curr

        return dummy_node.next

    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        if not head or not head.next or m == n:
            return head

        dummy_node = ListNode(-1)
        dummy_node.next = head

        prev = dummy_node
        for _ in range(m - 1):
            prev = prev.next

        curr = prev.next
        next = curr.next

        for _ in range(n - m):
            curr.next = next.next
            next.next = prev.next
            prev.next = next
            next = curr.next

        return dummy_node.next

    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if not head or not head.next or k == 1:
            return head

        dummy_node = ListNode(-1)
        dummy_node.next = head

        curr = dummy_node
        length = 0
        while curr.next:
            curr = curr.next
            length += 1

        start = dummy_node
        curr = old_head = dummy_node.next
        prev = next = None
        while length >= k:

            for _ in range(k):
                next = curr.next
                curr.next = prev
                prev = curr
                curr = next
            start.next = prev
            old_head.next = curr
            prev = old_head
            old_head = curr
            start = prev
            length -= k

        return dummy_node.next

    def ReverseList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head

        dummy_node = ListNode(-1)
        dummy_node.next = head

        prev = dummy_node
        curr = dummy_node.next
        next = curr.next

        while next:
            curr.next = next.next
            next.next = prev.next
            prev.next = next
            next = curr.next

        return dummy_node.next

    def ReverseList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head

        curr = head
        next = prev = None

        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next

        return prev

    def printListFromTailToHead(self, listNode: ListNode) -> list[int]:
        if not listNode:
            return None

        curr = listNode
        prev = next = None

        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next

        res = []
        while prev:
            res.append(prev.val)
            prev = prev.next

        return res

    def Merge(self, pHead1: ListNode, pHead2: ListNode) -> ListNode:

        dummy_node = ListNode(0)
        head = dummy_node

        while pHead1 and pHead2:
            if pHead1.val < pHead2.val:
                head.next = pHead1
                pHead1 = pHead1.next
            else:
                head.next = pHead2
                pHead2 = pHead2.next

            head = head.next

        head.next = pHead1 if pHead1 else pHead2

        return dummy_node.next


    def FindFirstCommonNode(self , pHead1 , pHead2 ) -> ListNode:
        head1 = pHead1
        head2 = pHead2
        while pHead1 != pHead2:
            pHead1 = pHead1.next if pHead1 else head2 #判断条件不是 pHead1.next是需要考虑他们永远也不会相遇的情况
            pHead2 = pHead2.next if pHead2 else head1
        return pHead1

    def deleteNode(self , head: ListNode, val: int) -> ListNode:

        dummy_node = ListNode(-1)
        dummy_node.next = head
        prev = dummy_node

        while head:
            if head.val == val:
                prev.next = head.next
            head = head.next
            prev = prev.next

        return dummy_node.next

    def deleteDuplication(self , pHead: ListNode) -> ListNode: ###################
        #空链表
        if pHead == None:
            return None
        res = ListNode(0)
        #在链表前加一个表头
        res.next = pHead
        cur = res
        while cur.next and cur.next.next:
            #遇到相邻两个节点值相同
            if cur.next.val == cur.next.next.val:
                temp = cur.next.val
                #将所有相同的都跳过
                while cur.next != None and cur.next.val == temp:
                    cur.next = cur.next.next
            else:
                cur = cur.next
        #返回时去掉表头
        return res.next


    def deleteDuplication(self , pHead: ListNode) -> ListNode:
        dummy_node = ListNode(-1)
        dummy_node.next = pHead
        d = {}
        while pHead:
            if pHead.val in d:
                d[pHead.val] += 1
            else:
                d[pHead.val] = 1
            pHead = pHead.next

        pHead = dummy_node.next
        prev = dummy_node
        while pHead:
            if d[pHead.val] == 1:
                prev.next = pHead
                prev = pHead
            else:
                prev.next = None
            pHead = pHead.next

        return dummy_node.next
