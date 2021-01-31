package week2;

import java.util.*;

//中序遍历 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/
public class InorderTraversal {
    //      Definition for a binary tree node.
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

    //法一：递归
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode node, ArrayList<Integer> res) {
        if (node == null) return;
        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);
    }


    //法二：栈（颜色标记法）
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

    public List<Integer> inorderTraversal_2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;//注意判空
        ColorNode colorNode = new ColorNode(root, NodeColor.WHITE);
        Stack<ColorNode> stack = new Stack<>();
        stack.push(colorNode);

        while (!stack.isEmpty()) {
            ColorNode topColorNode = stack.pop();
            if (topColorNode.color == NodeColor.WHITE) {
                if (topColorNode.node.right != null) {//注意判空
                    stack.push(new ColorNode(topColorNode.node.right, NodeColor.WHITE));
                }
                stack.push(new ColorNode(topColorNode.node, NodeColor.BLACK));
                if (topColorNode.node.left != null) {
                    stack.push(new ColorNode(topColorNode.node.left, NodeColor.WHITE));
                }
            } else if (topColorNode.color == NodeColor.BLACK) {
                res.add(topColorNode.node.val);
            }

        }

        return res;
    }


    //????
    public List<Integer> inorderTraversal_3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }



}
