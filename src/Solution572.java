public class Solution572 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 最直观的想法，时间O(m * n)，空间O(n)递归的栈空间
     * Runtime: 6 ms, faster than 82.97% of Java online submissions for Subtree of Another Tree.
     * Memory Usage: 40.2 MB, less than 97.78% of Java online submissions for Subtree of Another Tree.
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return t == null;
        if (t == null) return false;
        if (s.val == t.val && isValid(s, t)) {
            return true;
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    private boolean isValid(TreeNode s, TreeNode t) {
        if (s == null) return t == null;
        if (t == null) return false;
        if (s.val == t.val) {
            return isValid(s.left, t.left) && isValid(s.right, t.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);

        TreeNode root1 = new TreeNode(1);

        Solution572 solution572 = new Solution572();
        System.out.println(solution572.isSubtree(root, root1));
    }
}
