import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution234 {
    /**
     * 反转 + 比较，有点憨
     * Runtime: 5 ms, faster than 7.60% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 41.3 MB, less than 58.24% of Java online submissions for Palindrome Linked List.
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list0.add(p.val);
            p = p.next;
        }
        ListNode p1 = null, p2 = null, p3 = null;
        p1 = head;
        if (p1 != null) p2 = p1.next;
        if (p2 != null) p3 = p2.next;
        while (p2 != null) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            if (p3 != null) p3 = p3.next;
        }
        if (head != null) head.next = null;
        while (p1 != null) {
            list1.add(p1.val);
            p1 = p1.next;
        }
        for (int i = 0; i < list0.size(); i++) {
            if (!list0.get(i).equals(list1.get(i))) {
                return false;
            }
        }
        return true;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}