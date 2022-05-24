import java.util.*;
public class BalancedBinaryTree {
    public static void main(String[] args) {
//      int [] root = {3,9,20,null,null,15,7};

        BalancedBinaryTree obj = new BalancedBinaryTree();
        //TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(2);
//        obj.isBalanced(root);

        var root = buildBinaryTree(new Integer[] {1,2,2,3,3,null,null,4,4});
        System.out.println(obj.isBalanced(root)); // Should print false
        root = buildBinaryTree(new Integer[] {3,9,20,null,null,15,7});
        System.out.println(obj.isBalanced(root)); // Should return true
        root = buildBinaryTree(new Integer[] {});
        System.out.println(obj.isBalanced(root)); // Should return true
        root = buildBinaryTree(new Integer[] {1,2,2,3,null,null,3,4,null,null,4});
        System.out.println(obj.isBalanced(root)); // Should return false
    }

    public boolean isBalanced(TreeNode root) {
        //int counterLeft = 0, counterRight = 0;

//        int ans = isBalancedRecursion(root);

        return isBalancedRecursion(root) != -1;

//        if (ans == -1){
//            return false;
//        }

//        return true;
        // isBalanced();
    }

    public int isBalancedRecursion(TreeNode root){
        if (root == null) {
            return 0;
        }
//        if (root.left == null && root.right == null) {
//            return 1;
//        }

        int heightL = isBalancedRecursion(root.left);

        if (heightL == -1) {
            return -1;
        }

        int heightR = isBalancedRecursion(root.right);

        if (heightR == -1) {
            return -1;
        }

        int diff = Math.abs(heightR - heightL);

//        if (diff > 1) {
//            boolean balanced = false;
//        }

        boolean balanced = diff <= 1;

        if (balanced) {
            return Math.max(heightL, heightR) + 1;
        }

        return -1;

    }

    private static TreeNode buildBinaryTree(Integer[] input) {
        if (input == null || input.length == 0) return null;
        Queue<TreeNode> q = new ArrayDeque();
        var root = new TreeNode(input[0]);
        q.add(root);
        for (var i = 1; i < input.length; ++i) {
            var current = q.remove();
            if (input[i] != null) {
                current.left = new TreeNode(input[i]);
                q.add(current.left);
            }
            if (++i < input.length && input[i] != null) {
                current.right = new TreeNode(input[i]);
                q.add(current.right);
            }
        }
        return root;
    }

}
// Constructors are methods with no return type that have the same name as the class that contains them
//class TreeNode {
//    int val; //fields
//    TreeNode left; //fields
//    TreeNode right; //fields
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//
//    @Override
//    public String toString() {
//        return "TreeNode{" +
//                "val=" + val +
//                ", left=" + left +
//                ", right=" + right +
//                '}';
//    }
//}