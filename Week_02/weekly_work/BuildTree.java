package week2;

import java.util.Arrays;

//105. 从前序与中序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/ 21.11~22.00
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        TreeNode rootNode = new TreeNode(preorder[0]);
        int rootIndex = 0;//左子树的元素长度为roorIndex - 1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootNode.val) {
                rootIndex = i;
                break;
            }
        }

        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
//        int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex, inorder.length);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);//去掉中序遍历中的根节点
        rootNode.left = buildTree(preorderLeft, inorderLeft);
        rootNode.right = buildTree(preorderRight, inorderRight);
        return rootNode;
    }
}
