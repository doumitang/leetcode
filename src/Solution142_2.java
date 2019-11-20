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
public class Solution142_2 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 还要分析数学关系，我麻了
    public ListNode detectCycle(ListNode head) {
        ListNode p = head;
        ListNode q = meet(head);
        if (q == null) return null;
        while (p != q) {
            p = p.next;
            q = q.next;
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