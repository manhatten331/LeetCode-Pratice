import java.text.CharacterIterator;
import java.text.MessageFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class SubtreeAnotherTree {
    public static void main(String[] args) {
        SubtreeAnotherTree obj = new SubtreeAnotherTree();


        System.out.println(obj.isSubtree(TreeNode.parse("[3,4,5,1,2,null,null,null,null,0]"), TreeNode.parse("[4,1,2]")));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSubtree(root, subRoot, false);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot, boolean matchAll){
        if (root == null || subRoot == null){
            return root == subRoot;
        }

        //The matchAll parameter is a switch to tell the method to behave differently when it's true

        if (root.val == subRoot.val) {
            if (isSubtree(root.left, subRoot.left, true) && isSubtree(root.right, subRoot.right, true)) {
                return true;
            }
        }

        if (matchAll) {
            return false;
        }

        return isSubtree(root.left, subRoot, false) || isSubtree(root.right, subRoot, false);
    }
}

class TreeNode {
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

    @Override
    public String toString() {
        return MessageFormat.format("{0}: [{1} - {2}] end {0}:", val, left, right);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TreeNode && equals((TreeNode) obj);
    }

    public boolean equals(TreeNode other) {
        return other != null && val == other.val
                && (left == null && other.left == null || left.equals(other.left))
                && (right == null && other.right == null || right.equals(other.right));
    }

    public static TreeNode parse(String toParse) {
        return parse(new StringCharacterIterator(toParse));
    }

    private static TreeNode parse(CharacterIterator iter) {
        char c;
        try {
            var nodes = new ArrayList<TreeNode>();
            while ((c = iter.current()) != CharacterIterator.DONE) {
                if (c == ',' || c == '[' || c == ']' || Character.isWhitespace(c)) {
                    iter.next();
                    continue;
                }
                nodes.add(parseSingleNode(iter));
            }
            var root = nodes.get(0);
            var q = new ArrayDeque<TreeNode>();
            q.add(root);
            for (var i = 1; i < nodes.size(); i += 2) {
                var current = q.pop();
                if ((current.left = nodes.get(i)) != null)
                    q.add(current.left);
                if (i + 1 < nodes.size() && (current.right = nodes.get(i + 1)) != null)
                    q.add(current.right);
            }
            return root;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private static TreeNode parseSingleNode(CharacterIterator iter) throws Exception {
        return iter.current() == 'n'
                ? parseNull(iter)
                : new TreeNode(parseInt(iter));
    }

    private static TreeNode parseNull(CharacterIterator iter) throws Exception {
        if (iter.current() != 'n')
            throw new Exception("INVALID INPUT");
        var nullIter = new StringCharacterIterator("null");
        while (nullIter.next() != CharacterIterator.DONE) {
            if (nullIter.current() != iter.next())
                throw new Exception("INVALID INPUT");
        }
        iter.next();
        return null;
    }

    private static int parseInt(CharacterIterator iter) throws Exception {
        int sign = 1, result = 0;
        while (iter.current() == '-' || iter.current() == '+') {
            iter.next();
            sign *= iter.current() - ',';
        }
        if (!(iter.current() >= '0' && iter.current() <= '9'))
            throw new Exception("INVALID INT");
        for (var c = iter.current(); c >= '0' && c <= '9'; c = iter.next())
            result = result * 10 + (c - '0');
        return result * sign;
    }
}
