public class Solution147 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 遍历已排序链表中的每一个结点，通过逐个比较将未排序链表的每个结点插入到正确的位置
     * 时间O(n^2)，空间O(1)
     * Runtime: 30 ms, faster than 63.74% of Java online submissions for Insertion Sort List.
     * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Insertion Sort List.
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode ret, pHead;
        ret = new ListNode(0);
        pHead = head;
        while (pHead != null) {
            // 插入之前记录pHead的next
            ListNode pHeadNext = pHead.next;
            ListNode less = ret;
            while (less.next != null && less.next.val < pHead.val) {
                less = less.next;
            }
            pHead.next = less.next;
            less.next = pHead;

            pHead = pHeadNext;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);


        Solution147 solution147 = new Solution147();
        ListNode p = solution147.insertionSortList(head.next);
        while (p != null) {
            System.out.print("" + p.val + "->");
            p = p.next;
        }
    }
}
