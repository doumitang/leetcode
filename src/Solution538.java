/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution538 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int sum = 0;

    /**
     * 注意：是二叉搜索树，从大到小遍历即可
     * Runtime: 1 ms, faster than 88.16% of Java online submissions for Convert BST to Greater Tree.
     * Memory Usage: 39.9 MB, less than 65.63% of Java online submissions for Convert BST to Greater Tree.
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        recursion(root);
        return root;
    }

    private void recursion(TreeNode root) {
        if (root == null) return;
        if (root.right != null) recursion(root.right);
        root.val += sum;
        sum = root.val;
        if (root.left != null) recursion(root.left);
    }
}
