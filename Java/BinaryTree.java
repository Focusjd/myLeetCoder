import java.util.*;

class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;
     public TreeNode(int val) {
        this.val = val;
     }
 }


public class BinaryTree {
//    输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度，根节点的深度视为 1 。
//Easy Time: n Space: n
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

//给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
//输入 {1,2,3,4,#,#,5} 输出 [[1],[2,3],[4,5]]
//    递归
//    Easy Time n Space n
//    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        int depth = 0;
//        levelOrderHelper(root, res, depth);
//        return res;
//    }

    public void levelOrderHelper(TreeNode node, ArrayList<ArrayList<Integer>> res, int depth){
        if (node == null) return;
//        不能使用if(res.get(depth) == null)
//        当你尝试通过 res.get(depth) 访问 ArrayList 中的元素时，如果这个索引尚未有对应的列表（也就是说，这是你第一次访问这个深度的节点），
//        你会遇到 IndexOutOfBoundsException 异常。这是因为 ArrayList 在使用 .get(index) 方法时要求索引必须在当前列表的大小范围内。
        if (res.size() <= depth){
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(node.val);
        levelOrderHelper(node.left, res, depth+1);
        levelOrderHelper(node.right, res, depth+1);
    }

// 队列 使用offer、poll和peek方法
//    Time n Space n
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.peek();
                level.add(current.val);
                if (current.left!=null) queue.add(current.left);
                if (current.right!=null) queue.add(current.right);
                queue.poll();
            }
            res.add(level);
        }

        return res;
    }



//    求给定二叉树的最大深度，
//深度是指树的根节点到任一叶子节点路径上节点的数量。
//最大深度是所有叶子节点的深度的最大值。
    public int maxDepth (TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

//给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
//    Medium Time n Space n
//    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        if (pRoot == null) {
//            return res;
//        }
//        PrintHelper(pRoot, res, 0);
//        for (int i = 0; i < res.size(); i++) {
//            if (i % 2 ==1){
//                int length = res.get(i).size();
//                for (int j = 0; j < length / 2; j++) {
//                    int temp = res.get(i).get(j);
//                    res.get(i).set(j, res.get(i).get(length - j -1));
//                    res.get(i).set(length - j -1, temp);
//                }
//            }
//        }
//        return res;
//    }

    public void PrintHelper(TreeNode node, ArrayList<ArrayList<Integer>> res, int depth){
        if (node == null)return;
        if (res.size() == depth){
            res.add(new ArrayList<>());
        }
        res.get(depth).add(node.val);
        depth +=1;

        PrintHelper(node.left, res, depth);
        PrintHelper(node.right, res, depth);

    }

    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int depth = 0;
        while (!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);
                if (current.left!=null) queue.offer(current.left);
                if (current.right!=null) queue.offer(current.right);
            }
            if (depth % 2 ==1) Collections.reverse(level);
            depth++;
            res.add(level);
        }
        return res;
    }



}
