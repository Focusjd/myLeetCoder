索引数组，index = length - 1

如果再循环内数据结构进行改动，应该考虑循环终止条件变化
例如：            
for (int i = 0; i < queue.size; i++) {
TreeNode current = queue.poll();