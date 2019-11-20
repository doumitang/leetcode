/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution160 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 对空间复杂度有限制的题目，都有点东西
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        ListNode tA = null, tB = null;
        if (p == null || q == null) return null;
        while (p != q) {
            if (tA != null && tB != null && tA != tB) return null;
            // 记录单链表的尾结点
            if (p.next == null) tA = p;
            if (q.next == null) tB = q;
            p = p.next;
            q = q.next;
            if (p == null) p = headB;
            if (q == null) q = headA;
        }
        return p;
    }
}