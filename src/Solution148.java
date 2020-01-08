class Solution148 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 归并排序的分治思想，合并左排序结果和右排序结果，时间O(nlogn)，空间因为是链表所以O(1)
     * Runtime: 2 ms, faster than 99.81% of Java online submissions for Sort List.
     * Memory Usage: 41 MB, less than 57.89% of Java online submissions for Sort List.
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p!= null) {
            len++;
            p = p.next;
        }
        if (len <= 1) return head;
        return recursion(head, len);
    }

    public ListNode recursion(ListNode head, int len) {
        if (len == 1) {
            head.next = null;
            return head;
        }
        ListNode headRight = head;
        for (int i = 0; i < len / 2; i++) {
            headRight = headRight.next;
        }
        ListNode left = recursion(head, len / 2);
        ListNode right = recursion(headRight, len - len / 2);
        ListNode headNew = null;
        if (left.val < right.val) {
            headNew = left;
            left = left.next;
        } else {
            headNew = right;
            right = right.next;
        }
        ListNode temp = null, tail = headNew;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                tail = tail.next;
                left = left.next;
            } else {
                tail.next = right;
                tail = tail.next;
                right = right.next;
            }
        }
        if (left == null) tail.next = right;
        if (right == null) tail.next = left;
        /*while (p != null) {
            System.out.print("" + p.val + "->");
            p = p.next;
        }
        System.out.println();*/
        return headNew;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(1);


        Solution148 solution148 = new Solution148();
        ListNode p = solution148.sortList(head.next);
        while (p != null) {
            System.out.print("" + p.val + "->");
            p = p.next;
        }
    }
}