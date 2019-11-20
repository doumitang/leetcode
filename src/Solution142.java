/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode h = head;
        ListNode m = meet(h);
        if (m == null) return null;
        ListNode p = m;
        while (h != p) {
            p = p.next;
            if (p == m) h = h.next;
        }
        return p;
    }

    public ListNode meet(ListNode head) {
        ListNode p = head, q = head;
        while (p != null && q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) return p;
        }
        return null;
    }
}
