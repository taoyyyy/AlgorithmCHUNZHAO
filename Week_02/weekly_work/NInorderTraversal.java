package week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class NInorderTraversal {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //第二遍
    public List<Integer> postorder_2(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, NodeColor.WHITE));
        while (!stack.isEmpty()) {
            ColorNode topColorNode = stack.pop();
            if (topColorNode.color == NodeColor.WHITE) {
                if (topColorNode.node.children == null) continue;
                for (int i = topColorNode.node.children.size() - 1; i >= 0; i--) {
                    Node node = topColorNode.node.children.get(i);
                    stack.push(new ColorNode(node, NodeColor.WHITE));
                }
                stack.push(new ColorNode(topColorNode.node, NodeColor.GRAY));
            } else if (topColorNode.color == NodeColor.GRAY) {
                res.add(topColorNode.node.val);
            }
        }
        return res;
    }


    class ColorNode {
        Node node;
        NodeColor color;

        public ColorNode(Node node, NodeColor color) {
            this.node = node;
            this.color = color;
        }
    }

    enum NodeColor {
        WHITE, GRAY
    }

    //第一遍
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, NodeColor.WHITE));
        while (!stack.isEmpty()) {
            ColorNode topColorNode = stack.pop();
            if (topColorNode.color == NodeColor.GRAY) {
                res.add(topColorNode.node.val);
            } else if (topColorNode.color == NodeColor.WHITE) {
                stack.push(new ColorNode(topColorNode.node, NodeColor.GRAY));
                //需要确保子节点的遍历顺序
//                for (Node node : topColorNode.node.children) {
//                    if (node != null) {
//                        stack.push(new ColorNode(node, NodeColor.WHITE));
//                    }
//                }

                for (int i = topColorNode.node.children.size() - 1; i >= 0; i--) {
                    Node node = topColorNode.node.children.get(i);
                    if (node != null) {
                        stack.push(new ColorNode(node, NodeColor.WHITE));
                    }
                }
            }
        }
        return res;
    }


    public List<Integer> postorder_(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<Node> s = new Stack<Node>();
        if (root == null)
            return ans;
        s.push(root);

        while (!s.isEmpty()) {
            Node curr = s.pop();
            ans.addFirst(curr.val);
            for (Node child : curr.children) {
                if (child != null)
                    s.push(child);
            }
        }
        return ans;
    }

}
