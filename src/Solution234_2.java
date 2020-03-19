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
class Solution234_2 {
    /**
     * 反转后半部分链表，再比较
     * Runtime: 3 ms, faster than 22.48% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 40.7 MB, less than 99.83% of Java online submissions for Palindrome Linked List.
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!list.get(i).equals(list.get(size - i - 1))) {
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