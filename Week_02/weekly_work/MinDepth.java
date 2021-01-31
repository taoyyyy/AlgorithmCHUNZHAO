package week2;

//111. 二叉树的最小深度 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/ 15.20~15.35
public class MinDepth {
    //    root节点左右孩子只有一个为空，说明root节点不是叶子节点，那此时的最小深度就是不为空的那棵子树的最小深度+1
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int i = minDepth(root.left);
        int i1 = minDepth(root.right);
        return (i == 0 || i1 == 0) ? i + i1 + 1 : Math.min(i, i1) + 1;
    }
}
