import java.util.LinkedList;
import java.util.Queue;

public class Solution116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * BFS广度优先遍历
     * Runtime: 2 ms, faster than 39.68% of Java online submissions for Populating Next Right Pointers in Each Node.
     * Memory Usage: 39.7 MB, less than 6.35% of Java online submissions for Populating Next Right Pointers in Each Node.
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) node.next = queue.peek();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }
}
