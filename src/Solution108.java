public class Solution108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 因为需要是平衡树，所以递归过程中就取位置在中间的作为根节点进行构造
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     * Memory Usage: 39.5 MB, less than 5.16% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        Solution108 solution108 = new Solution108();
        solution108.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
