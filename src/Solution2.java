/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution2 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        int up = 0;
        while (l1 != null || l2 != null) {
            int a = 0, b = 0, sum;
            if (l1 != null) a = l1.val;
            if (l2 != null) b = l2.val;
            sum = (a + b + up) % 10;
            up = (a + b + up) / 10;
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (up > 0) {
            dummy.next = new ListNode(up);
            dummy = dummy.next;
        }
        return ans.next;
    }
}