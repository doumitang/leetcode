public class Solution437 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int ans;

    /**
     * dps + dp
     * Runtime: 4 ms, faster than 94.72% of Java online submissions for Path Sum III.
     * Memory Usage: 39.3 MB, less than 86.36% of Java online submissions for Path Sum III.
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        ans = 0;
        int[] dp = new int[1001];
        dfs(root, sum, dp, 1);
        return ans;
    }

    private void dfs(TreeNode root, int sum, int[] dp, int index) {
        if (root == null) return;
        dp[index] = dp[index - 1] + root.val;
        for (int i = 0; i < index; i++) {
            if (dp[index] - dp[i] == sum) ans++;
        }
        dfs(root.left, sum, dp, index + 1);
        dfs(root.right, sum, dp, index + 1);
    }
}
