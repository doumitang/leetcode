public class Solution543 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int ans = 0;

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
     * Memory Usage: 38.7 MB, less than 20.78% of Java online submissions for Diameter of Binary Tree.
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return ans;
    }

    private int recursion(TreeNode root) {
        if (root == null) return 0;
        int left = 0, right = 0;
        if (root.left != null) left = 1 + recursion(root.left);
        if (root.right != null) right = 1 + recursion(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }
}
