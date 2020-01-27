public class Solution24 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
     * Memory Usage: 37.2 MB, less than 5.50% of Java online submissions for Swap Nodes in Pairs.
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy, p2 = null, p3 = null, p4 = null;
        while (p1.next != null && p1.next.next != null) {
            p2 = p1.next;
            p3 = p2.next;
            p4 = p3.next;
            p1.next = p3;
            p3.next = p2;
            p2.next = p4;
            p1 = p2;
        }
        return dummy.next;
    }
}
