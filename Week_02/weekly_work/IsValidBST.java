package week2;

import java.util.Stack;

//98. 验证二叉搜索树 https://leetcode-cn.com/problems/validate-binary-search-tree/ 11.18~12.00
//思路：利用中序遍历有序的特点，存储中序遍历的前一个值
public class IsValidBST {

    long preVal = -Long.MAX_VALUE;//输入可能为负值,最好用Long.MIN_VALUE替代Integer.MIN_VALUE

    //法一：递归
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;//易漏

        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= preVal) return false;

        preVal = root.val;

        if (!isValidBST(root.right)) return false;

        return true;
    }


    class ColorNode {
        TreeNode node;
        NodeColor color;

        public ColorNode(TreeNode node, NodeColor color) {
            this.node = node;
            this.color = color;
        }
    }

    //白色意味着需要继续遍历，黑色意味着可以直接添加到结果集合中
    enum NodeColor {
        WHITE, BLACK
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, NodeColor.WHITE));
        while (!stack.isEmpty()) {
            ColorNode topNode = stack.pop();
            if (topNode.color == NodeColor.WHITE) {
                if (topNode.node.right != null) stack.push(new ColorNode(topNode.node.right, NodeColor.WHITE));
                stack.push(new ColorNode(topNode.node, NodeColor.BLACK));
                if (topNode.node.left != null) stack.push(new ColorNode(topNode.node.left, NodeColor.WHITE));

            } else if (topNode.color == NodeColor.BLACK) {
                if (preVal >= topNode.node.val) return false;
                preVal = topNode.node.val;
            }
        }
        return true;
    }




























/*    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }*/


/*    public boolean isValidBST_2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }*/

}
