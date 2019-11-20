import java.util.ArrayList;
import java.util.List;

public class Solution113_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] array = new int[sum + 1];
        dfs(root, sum, ans, array, 0);
        return ans;
    }

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Path Sum II.
     * Memory Usage: 38.2 MB, less than 100.00% of Java online submissions for Path Sum II.
     * @param root
     * @param sum
     * @param ans
     * @param array
     * @param index
     */
    private void dfs(TreeNode root, int sum, List<List<Integer>> ans, int[] array, int index) {
        if (root == null) return;
        array[index] = root.val;
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= index; i++) {
                temp.add(array[i]);
            }
            ans.add(temp);
        }
        dfs(root.left, sum - root.val, ans, array, index + 1);
        dfs(root.right, sum - root.val, ans, array, index + 1);
    }
}
