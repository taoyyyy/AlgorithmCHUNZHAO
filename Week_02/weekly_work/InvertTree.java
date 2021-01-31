package week2;

import java.util.Stack;

//226. 翻转二叉树 https://leetcode-cn.com/problems/invert-binary-tree/description/ 10.55~11.5
public class InvertTree {
    //     * Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //法一
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //法二
    public TreeNode invertTree_2(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode topNode = stack.pop();
            TreeNode temp = topNode.left;
            topNode.left = topNode.right;
            topNode.right = temp;
            if (topNode.left != null) {
                stack.push(topNode.left);
            }

            if (topNode.right != null) {
                stack.push(topNode.right);
            }
        }
        return root;
    }
}

