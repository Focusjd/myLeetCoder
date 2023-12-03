import com.sun.source.tree.Tree;

import javax.xml.transform.stax.StAXResult;
import java.security.cert.CertPath;
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
//    给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
    public int[] preorderTraversal (TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorderTraversalHelper(root, res);
        return res.stream().mapToInt(i -> i).toArray();
    }
    public void preorderTraversalHelper(TreeNode node, ArrayList<Integer> res){
        if (node == null) {
            return;
        }
        res.add(node.val);
        preorderTraversalHelper(node.left, res);
        preorderTraversalHelper(node.right, res);
    }
//    中序遍历
    public int[] inorderTraversal (TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversalHelper(root, list);
        return list.stream().mapToInt(Integer::intValue).toArray();

    }


    public void inorderTraversalHelper(TreeNode node, ArrayList<Integer> res){
        if (node == null) {
            return;
        }

        inorderTraversalHelper(node.left, res);
        res.add(node.val);
        inorderTraversalHelper(node.right, res);
    }


    //    输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
//    最长路径的长度为树的深度，根节点的深度视为 1 。
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
// queue Time n Space n
//    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        if (pRoot == null) {
//            return res;
//        }
//
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.add(pRoot);
//        int depth = 0;
//        while (!queue.isEmpty()){
//            ArrayList<Integer> level = new ArrayList<>();
//            int levelSize = queue.size();
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode current = queue.poll();
//                level.add(current.val);
//                if (current.left!=null) queue.offer(current.left);
//                if (current.right!=null) queue.offer(current.right);
//            }
//            if (depth % 2 ==1) Collections.reverse(level);
//            depth++;
//            res.add(level);
//        }
//        return res;
//    }

//    double stack Time n Space n
    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(pRoot);
        int depth = 0;
        while (!stack1.empty() || !stack2.empty()){
            ArrayList<Integer> level = new ArrayList<>();

            if (depth %2 ==0){
                int levelSize = stack1.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode current = stack1.pop();
                    level.add(current.val);
                    if (current.left!=null) stack2.push(current.left);
                    if (current.right!=null) stack2.push(current.right);
                }
            }else {
                int levelSize = stack2.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode current = stack2.pop();
                    level.add(current.val);
                    if (current.right!=null) stack1.push(current.right);
                    if (current.left!=null) stack1.push(current.left);
                }
            }
            res.add(level);
            depth++;
        }
        return res;
    }
//给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径。
//1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
//2.叶子节点是指没有子节点的节点
//3.路径只能从父节点到子节点，不能从子节点到父节点
//4.总节点数目为n
    public boolean hasPathSum (TreeNode root, int sum) {
        if (root == null) //终止条件需要学习
            return false;
        if (root.left == null && root.right == null && sum - root.val ==0)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> path = new ArrayList<>();
        FindPathHelper(root, target, res, path);
        return res;
    }

//    输入一颗二叉树的根节点root和一个整数expectNumber，找出二叉树中结点值的和为expectNumber的所有路径。
    public void FindPathHelper(TreeNode node, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path){
        if (node == null) {
            return;
        }
        sum -= node.val;
        path.add(node.val);

        if (node.left == null && node.right == null && sum == 0){
            res.add(new ArrayList<>(path));
        }

        FindPathHelper(node.left, sum, res, path);
        FindPathHelper(node.right, sum, res, path);

        path.remove(path.size()-1);

    }
//给定一个二叉树root和一个整数值 sum ，求该树有多少路径的的节点值之和等于 sum 。
//1.该题路径定义不需要从根节点开始，也不需要在叶子节点结束，但是一定是从父亲节点往下到孩子节点
//2.总节点数目为n
//3.保证最后返回的路径个数在整形范围内(即路径个数小于231-1)

    public int FindAnyPath (TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int number = FindAnyPathDFS(root, sum);

        number += FindAnyPath(root.left, sum);
        number += FindAnyPath(root.right, sum);


        return number;
    }

    public int FindAnyPathDFS(TreeNode node, int sum){
        if (node == null) {
            return 0;
        }
        sum -= node.val;
        int result = (sum == 0) ? 1 : 0; //可以继续的关键

        // 继续在左右子树中寻找符合条件的路径
        result += FindAnyPathDFS(node.left, sum);
        result += FindAnyPathDFS(node.right, sum);

        return result;
    }



//    已知两颗二叉树，将它们合并成一颗二叉树。
//    合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode node = new TreeNode(t1.val + t2.val);


        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);

        node.left = left;
        node.right = right;
        return node;
    }


//    给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
    public boolean isSymmetrical (TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetricalHelper(pRoot.left, pRoot.right);
    }
    public boolean isSymmetricalHelper(TreeNode left, TreeNode right){
        if (left == null && right == null) {
            return true; //终止条件需要学习
        }
        if (left == null || right == null || left.val != right.val)
            return false;

        return isSymmetricalHelper(left.right, right.left) && isSymmetricalHelper(left.left, right.right);
    }

//    操作给定的二叉树，将其变换为源二叉树的镜像。
    public TreeNode Mirror (TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }

        TreeNode left = Mirror(pRoot.left);
        TreeNode right = Mirror(pRoot.right);

        pRoot.left = right;
        pRoot.right = left;
        return pRoot;
    }



//    判断是否是二叉搜索树
    public boolean isValidBST (TreeNode root) {
        return isValidBSTHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode node, int upper, int lower){
        if (node == null)
            return true;

        if (node.val>upper || node.val<lower)
            return false;

        boolean leftRes = isValidBSTHelper(node.left, node.val, lower);
        boolean rightRes = isValidBSTHelper(node.right, upper, node.val);
        return leftRes && rightRes;
    }

//    判断是否是平衡二叉树
    public boolean IsBalanced_Solution (TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isBalancedHelper(pRoot) != -1;
    }
    public int isBalancedHelper(TreeNode node){
        if (node == null) {
            return 0;
        }
        int leftDepth = isBalancedHelper(node.left);

        int rightDepth = isBalancedHelper(node.right);

        if (Math.abs(leftDepth-rightDepth)>1 || leftDepth==-1 || rightDepth==-1)
            return -1;

        return Math.max(leftDepth, rightDepth) + 1;
    }


//    判断是否是完全二叉树
//    Medium Time n Space n
    public boolean isCompleteTree (TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if (curr == null) {
                flag = true;
                continue;
            }
            if (flag)
                return false;

            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return true;
    }

//    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。如下图所示
    TreeNode prev = null;
    TreeNode head = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        TreeNode left = Convert(pRootOfTree.left);
        if (prev == null){
            prev = pRootOfTree;
            head = pRootOfTree;
        }else {
            prev.right = pRootOfTree;
            pRootOfTree.left = prev;
            prev = pRootOfTree;
        }
        TreeNode right = Convert(pRootOfTree.right);

        return head;
    }

//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        if (root == null)
            return -1;
        if (root.val == p || root.val == q)
            return root.val;

        int left = lowestCommonAncestor(root.left, p, q);
        int right = lowestCommonAncestor(root.right, p ,q);

        if (left != -1 && right != -1)
            return root.val;

        return left != -1 ? left : right; //核心，如何让结果传递上去
    }

//
//    您提出的疑问是关于当p和q为父节点和子节点关系时，我的解法是否仍然有效。实际上，这个解法是可以处理p和q为父子关系的情况的。
//    解释如下：
//    当p和q中的一个是另一个的祖先时，算法会在找到第一个节点（假设为p）的时候返回这个节点。这是因为递归搜索首先会遍历到p，并且由于q在p的子树中，所以对p的子树的搜索会返回q。
//    在这种情况下，一旦我们找到p，我们实际上已经找到了最低公共祖先，因为另一个节点q是p的后代。
//    算法在遍历到p时会返回p到其父调用，而由于q是p的后代，所以p的子树中会找到q，而p的另一侧子树将返回null。
//    最终，p作为第一个找到的节点将被返回作为最低公共祖先。
    public TreeNode lowestCommonAncestorTreeNode (TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }

        if (root.val == p || root.val ==q)
            return root;

        TreeNode left = lowestCommonAncestorTreeNode(root.left, p, q);
        TreeNode right = lowestCommonAncestorTreeNode(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left != null ? left : right; // 核心： 如何返回结果
    }

//给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
//    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
//
//    }







}
