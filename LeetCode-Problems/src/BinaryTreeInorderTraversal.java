import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
//  It's because you made one instance, and you used a field to accumulate
    List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        BinaryTreeInorderTraversal obj = new BinaryTreeInorderTraversal();

        System.out.println(obj.inorderTraversal(TreeNode.parse("[1,null,2,3]")));
        System.out.println(obj.inorderTraversal(TreeNode.parse("[7, 3, 15, null, null, 9, 20]")));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        // Pay attention to the type ^^^^
        if (root == null) {
            return ans;
        }

        inorderTraversal(root.left);

        ans.add(root.val);

        inorderTraversal(root.right);

        return ans;
    }

}
