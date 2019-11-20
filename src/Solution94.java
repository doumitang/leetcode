import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution94 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) recursion(ans, root);
        return ans;
    }

    private void recursion(List<Integer> ans, TreeNode root) {
        if (root.left != null) recursion(ans, root.left);
        ans.add(root.val);
        if (root.right != null) recursion(ans, root.right);
    }
}