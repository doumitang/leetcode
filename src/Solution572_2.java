public class Solution572_2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private StringBuilder sPreOrder = new StringBuilder();
    private StringBuilder tPreOrder = new StringBuilder();

    /**
     * 前序遍历获得字符串（包含null），将问题转换为字符串匹配问题
     * Runtime: 4 ms, faster than 98.21% of Java online submissions for Subtree of Another Tree.
     * Memory Usage: 37.8 MB, less than 100.00% of Java online submissions for Subtree of Another Tree.
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        preOrder(s, sPreOrder);
        preOrder(t, tPreOrder);
        /*
        contains函数复杂度为O(m * n)，总时间O(m + n + m * n)，总空间O(m + n)
        Runtime: 4 ms, faster than 98.21% of Java online submissions for Subtree of Another Tree.
        Memory Usage: 39.6 MB, less than 100.00% of Java online submissions for Subtree of Another Tree.
         */
        return sPreOrder.toString().contains(tPreOrder.toString());

        /*
        KMP算法复杂度为O(m + n)，总时间O(m + n)，总空间O(m + n)
        不知道为什么在LeetCode上跑没有contains函数快
        Runtime: 5 ms, faster than 95.41% of Java online submissions for Subtree of Another Tree.
        Memory Usage: 40.2 MB, less than 97.78% of Java online submissions for Subtree of Another Tree.
         */
//        return strStr(sPreOrder.toString(), tPreOrder.toString()) >= 0;

    }

    private void preOrder(TreeNode s, StringBuilder sPreOrder) {
        if (s == null) {
            sPreOrder.append("*");
            return;
        }
        sPreOrder.append("#").append(s.val);
        preOrder(s.left, sPreOrder);
        preOrder(s.right, sPreOrder);
    }

    // KMP算法实现
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        char[] t = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int m = t.length, n = p.length;
        int i = 0, j = 0;
        int[] next = getNext(p);
        while (i < m && j < n) {
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == n) return i - n;
        else return -1;
    }

    public int[] getNext(char[] p) {
        int len = p.length;
        int[] next = new int[len];
        next[0] = -1;
        int j = 0, k = -1;
        while (j < len - 1) {
            if (k == -1 || p[j] == p[k]) {
                // 优化的next数组
                if (p[++j] == p[++k]) {
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
