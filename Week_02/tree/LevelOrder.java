package week2;

import java.util.ArrayList;
import java.util.List;

//429. N 叉树的层序遍历 https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
public class LevelOrder {
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        traverse(root, 0);
        return res;
    }

    private void traverse(Node node, int level) {
        if (node == null) return;

        List<Integer> list;
//        if (res.get(level) == null) { //index越界
        if (res.size() <= level) {
            list = new ArrayList<>();
            res.add(level, list);
        } else {
            list = res.get(level);
        }
        list.add(node.val);


        for (Node childNode : node.children) {
            if (childNode != null) {
//                traverse(childNode, ++level); //++level会改变level的值
                traverse(childNode, level + 1);
            }
        }
    }










    /*private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) traverseNode(root, 0);
        return result;
    }


    private void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1);
        }
    }*/

}
