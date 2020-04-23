import java.util.*;

public class Solution103 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 用队列进行广度优先遍历，只不过是结果的展现形式不一样
     * Runtime: 1 ms, faster than 68.38% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     * Memory Usage: 38.5 MB, less than 5.77% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean toLeft = false;
        int len = queue.size();
        while (!queue.isEmpty()) {
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (toLeft) {
                    temp.add(0, node.val);
                } else {
                    temp.add(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(new ArrayList<>(temp));
            temp.clear();
            toLeft = !toLeft;
            len = queue.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution103 solution103 = new Solution103();
        solution103.zigzagLevelOrder(root);
    }
}
