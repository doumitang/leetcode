public class Solution337 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 用长度为2的数组一次性返回当前节点偷/不偷两种状态的最优解，可以避免重复遍历
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber III.
     * Memory Usage: 41 MB, less than 13.89% of Java online submissions for House Robber III.
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int ans[] = robCore(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] robCore(TreeNode root) {
        int[] ret = new int[2];
        if (root == null) return ret;
        int[] left = robCore(root.left);
        int[] right = robCore(root.right);
        ret[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ret[1] = root.val + left[0] + right[0];
        return ret;
    }
}
