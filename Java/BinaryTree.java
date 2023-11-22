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
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int depth = 0;
        levelOrderHelper(root, res, depth);
        return res;
    }

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



}
