public class Solution105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode recursion(int[] preorder, int i, int[] inorder, int start, int end) {
        if (i >= preorder.length || start > end) return null;
        TreeNode root = new TreeNode(preorder[i]);
        int index = start;
        for (; index <= end; index++) {
            if (inorder[index] == root.val) break;
        }
        root.left = recursion(preorder, i + 1, inorder, start, index - 1);
        root.right = recursion(preorder, i + (index - start) + 1, inorder, index + 1, end); // (index - start)表示左子树中节点的个数，太秀了！！！
        return root;
    }
}
