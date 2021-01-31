package week2;

import java.util.Arrays;
import java.util.LinkedList;

//297. 二叉树的序列化与反序列化 https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/ 15.37~16.33
public class TreeCodec {
    //序列化时是前序遍历，所以在反序列化时要先构建左子树，再构建右子树
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "X";
        String rightStr = serialize(root.right);
        String leftStr = serialize(root.left);
        return root.val + "," + leftStr + rightStr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] arr = data.split(",");
        LinkedList<String> deque = new LinkedList<>(Arrays.asList(arr));
        return buildNode(deque);
    }

    private TreeNode buildNode(LinkedList<String> deque) {
        String str = deque.poll();
        if ("X".equals(str)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = buildNode(deque);
        node.right = buildNode(deque);
        return node;
    }


}
