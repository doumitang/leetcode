public class Solution138_2 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 在原链表的每个节点后面都插入其深拷贝节点，然后可以很方便的拷贝 random 指针，时间 O(n)，空间 O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
     * Memory Usage: 40.8 MB, less than 5.61% of Java online submissions for Copy List with Random Pointer.
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node pHead = head, copy = null;
        // 插入深拷贝节点
        while (pHead != null) {
            copy = new Node(pHead.val);
            copy.next = pHead.next;
            pHead.next = copy;
            pHead = copy.next;
        }
        // 拷贝 random 指针
        pHead = head;
        while (pHead != null) {
            copy = pHead.next;
            if (pHead.random != null) copy.random = pHead.random.next;
            pHead = copy.next;
        }
        // 分离出深拷贝链表和原链表
        Node newHead = head.next, pNewHead = newHead;
        pHead = head;
        while (pHead != null) {
            if (pHead.next != null) pHead.next = pHead.next.next;
            pHead = pHead.next;
            if (pNewHead.next != null) pNewHead.next = pNewHead.next.next;
            pNewHead = pNewHead.next;
        }
        return newHead;
    }
}
