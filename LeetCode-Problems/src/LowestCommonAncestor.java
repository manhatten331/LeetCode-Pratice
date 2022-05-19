public class LowestCommonAncestor {
    public static void main(String[] args) {
        LowestCommonAncestor obj =  new LowestCommonAncestor();

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p.val == root.val || q.val == root.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }

        if (left != null && right != null) {
            return root;
        }

        if (left == null && right != null) {
            return right;
        }

//        if (left != null && right == null) {
//            return left;
//        }

        return left;
    }

}

//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}


