package week2;

//104. 二叉树的最大深度 https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/ 15.08
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int i = maxDepth(root.left);
        int i1 = maxDepth(root.right);
        return Math.max(i, i1) + 1;
//        return traversal(root, 0);
    }

    private int traversal(TreeNode root, int level) {
        if (root == null) return level;
        int leftLevel = traversal(root.left, level + 1);
        int rightLevel = traversal(root.right, level + 1);
        return Math.max(leftLevel, rightLevel);
    }
}
