public class Solution148_2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 思想一样，改写为用快慢指针获取链表的中间节点
     * Runtime: 3 ms, faster than 98.01% of Java online submissions for Sort List.
     * Memory Usage: 39.9 MB, less than 98.25% of Java online submissions for Sort List.
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return recursion(head);
    }

    private ListNode recursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        // 找到中间节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 这两句话有点东西，学到了
        ListNode left = head, right = slow.next;
        slow.next = null;
        ListNode leftRes = recursion(left);
        ListNode rightRes = recursion(right);
        // 合并
        return merge(leftRes, rightRes);
    }

    private ListNode merge(ListNode leftRes, ListNode rightRes) {
        if (leftRes == null) return rightRes;
        if (rightRes == null) return leftRes;

        ListNode ret = null, p = null;
        if (leftRes.val < rightRes.val) {
            ret = leftRes;
            leftRes = leftRes.next;
        } else {
            ret = rightRes;
            rightRes = rightRes.next;
        }

        p = ret;
        while (leftRes != null && rightRes != null) {
            if (leftRes.val < rightRes.val) {
                p.next = leftRes;
                leftRes = leftRes.next;
            } else {
                p.next = rightRes;
                rightRes = rightRes.next;
            }
            p = p.next;
        }
        if (leftRes != null) p.next = leftRes;
        else p.next = rightRes;
        return ret;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(1);


        Solution148_2 solution148 = new Solution148_2();
        ListNode p = solution148.sortList(head.next);
        while (p != null) {
            System.out.print("" + p.val + "->");
            p = p.next;
        }
    }
}
