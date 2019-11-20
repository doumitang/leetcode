/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution83 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
     * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cur = head, p = head.next;
        while (cur != null) {
            while (p != null && p.val == cur.val) {
                p = p.next;
            }
            cur.next = p;
            cur = cur.next;
        }
        return head;
    }
}
