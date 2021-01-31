package week2;

//236. 二叉树的最近公共祖先  https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/ 20.20~21.10
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;//已知p、q 为不同节点且均存在于给定的二叉树中，因此当p或者q为root时，可以认为结果就是root??
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

}
