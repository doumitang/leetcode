import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution98 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode p = root.left, q = root.right;
        if (p == null && q == null) return true;
        if (p != null && q == null) return getMaxVal(p) < root.val && isValidBST(p);
        if (p == null && q != null) return root.val < getMinVal(q) && isValidBST(q);
        return getMaxVal(p) < root.val && root.val < getMinVal(q) && isValidBST(root.left) && isValidBST(root.right);
    }

    private int getMinVal(TreeNode q) {
        while (q.left != null) q = q.left;
        return q.val;
    }

    private int getMaxVal(TreeNode p) {
        while (p.right != null) p = p.right;
        return p.val;
    }
}