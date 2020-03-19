/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution234_3 {
    /**
     * 反转后半部分链表，再比较
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 先用快慢指针找到需要进行反转的头指针的前一个位置
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 此时slow指向需要进行反转的头指针的前一个位置
        // 开始从slow.next开始反转
        ListNode tail = reverse(slow.next);
        while (tail != null) {
            if (tail.val != head.val) return false;
            tail = tail.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode headNew = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return headNew;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}