import sys


# 用两个栈来实现一个队列，使用n个元素来完成 n 次在队列尾部插入整数(push)和n次在队列头部删除整数(pop)的功能。
# 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
class Solution:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []
    def push(self, node):
        self.stack1.append(node)
    def pop(self):
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

class Solution:
    def __init__(self):
        self.stack = []
        self.min_stack = []
        self.min_value = sys.maxsize
    def push(self, node):
        self.stack.append(node)
        if node < self.min_value:
            self.min_value = node
        self.min_stack.append(self.min_value)

    def pop(self):
        self.min_stack.pop()
        self.min_value = self.min()
        self.stack.pop()

    def top(self):
        return self.stack[-1]
    def min(self):
        return self.min_stack[-1]
