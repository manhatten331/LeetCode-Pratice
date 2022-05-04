import java.util.*;
public class PreorderTraversal {
    public static void main(String[] args) {

    }

    public void visitChildren(Node n, List<Integer> list) {

        list.add(n.val);

        for (Node child : n.children) {
            visitChildren(child, list);
        }

    }

    public List<Integer> preorder(Node root) {

        List<Integer> list = new ArrayList<>();

        visitChildren(root, list);
        return list;
    };

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
