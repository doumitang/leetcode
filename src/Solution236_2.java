/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution236_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode ans;

    /**
     * 递归法
     * Runtime: 5 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 35.3 MB, less than 5.01% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        DFS(root, p, q);
        return ans;
    }

    private boolean DFS(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        int left = DFS(root.left, p, q) ? 1 : 0;
        int right = DFS(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid >= 2) ans = root;
        return left + right + mid > 0;
    }
}