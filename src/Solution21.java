public class Solution21 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 归并排序的合并步骤
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 40.8 MB, less than 10.10% of Java online submissions for Merge Two Sorted Lists.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode p = ans;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        } else {
            while (l1 != null) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            }
        }
        return ans.next;
    }
}
