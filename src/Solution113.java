import java.util.ArrayList;
import java.util.List;

public class Solution113 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recursion(root, sum, ans, temp);
        return ans;
    }

    /**
     * list创建耗时太大？
     * Runtime: 2 ms, faster than 36.16% of Java online submissions for Path Sum II.
     * Memory Usage: 39.7 MB, less than 19.69% of Java online submissions for Path Sum II.
     * @param root
     * @param sum
     * @param ans
     * @param temp
     */
    private void recursion(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> temp) {
        if (root == null) return;
        if (root.left == null && root.right == null && root.val == sum) ans.add(temp);
        temp.add(root.val);
        List<Integer> tempLeft, tempRight;
        tempLeft = new ArrayList<>(temp);
        tempRight = new ArrayList<>(temp);
        recursion(root.left, sum - root.val, ans, tempLeft);
        recursion(root.right, sum - root.val, ans, tempRight);
    }
}
