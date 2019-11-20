import java.util.Stack;

public class Solution101_2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Tuple {
        TreeNode p1;
        TreeNode p2;

        Tuple(TreeNode p1, TreeNode p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        int cmp() {
            if (p1 == null && p2 == null) return 2;
            if (p1 != null && p2 == null || p1 == null && p2 != null) return 1;
            return p1.val == p2.val ? 0 : 1;
        }

        @Override
        public String toString() {
            String str1, str2;
            if (p1 == null) str1 = "null";
            else str1 = "" + p1.val;
            if (p2 == null) str2 = "null";
            else str2 = "" + p2.val;
            return "" + str1 + " " + str2;
        }
    }

    // 迭代
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<Tuple> stack = new Stack<>();
        Tuple tuple = new Tuple(root, root);
        stack.push(tuple); // 根节点入栈
        TreeNode p = root.left, q = root.right;
        tuple = new Tuple(p, q);
        while (!stack.isEmpty()) {
            if (tuple.cmp() == 1) return false;
            else if (tuple.cmp() == 0) {
                stack.push(tuple);
                System.out.println("push " + tuple.toString());
                tuple = new Tuple(tuple.p1.left, tuple.p2.right);
            } else {
                tuple = stack.pop();
                System.out.println("pop " + tuple.toString());
                tuple = new Tuple(tuple.p1.right, tuple.p2.left);
            }
        }
        return true;
    }
}
