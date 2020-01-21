public class Solution23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 分治合并，时间O(N * log k)，其中 N 为总节点数，k为链表数，空间O(1)
     * Runtime: 2 ms, faster than 99.14% of Java online submissions for Merge k Sorted Lists.
     * Memory Usage: 44.2 MB, less than 24.05% of Java online submissions for Merge k Sorted Lists.
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode res1 = mergeKLists(lists, left, mid);
        ListNode res2 = mergeKLists(lists, mid + 1, right);
        return merge(res1, res2);
    }

    private ListNode merge(ListNode res1, ListNode res2) {
        ListNode dummy, p;
        dummy = new ListNode(0);
        p = dummy;
        while (res1 != null && res2 != null) {
            if (res1.val < res2.val) {
                p.next = res1;
                res1 = res1.next;
            } else {
                p.next = res2;
                res2 = res2.next;
            }
            p = p.next;
        }
        // 因为是链表，所以可以用if判断之后直接连上
        if (res1 != null) {
            p.next = res1;
        }
        if (res2 != null) {
            p.next = res2;
        }
        return dummy.next;
    }
}
