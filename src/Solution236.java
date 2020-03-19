/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 双重递归，重复访问，有点垃圾
     * Time Limit Exceeded
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (DFS(root, p) == -1 || DFS(root, q) == -1) return null;
        if (DFS(root, p) != DFS(root, q)) return root;
        if (DFS(root, p) == 1 && DFS(root, q) == 1) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }

    private int DFS(TreeNode root, TreeNode p) {
        if (root.val == p.val) return 0;
        if (root.left != null && DFS(root.left, p) != -1) return 1;
        if (root.left != null && DFS(root.right, p) != -1) return 2;
        return -1;
    }
}