import java.util.HashMap;
import java.util.Map;

public class Solution138 {
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

    private Map<Node, Node> map = new HashMap<>();

    /**
     * 用 map 存储原节点到深拷贝节点的映射，时间 O(n)，空间 O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
     * Memory Usage: 41.6 MB, less than 5.61% of Java online submissions for Copy List with Random Pointer.
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node copyHead = new Node(head.val);
        map.put(head, copyHead);
        Node pCopy = copyHead, pHead = head;
        Node next = null, random = null;
        while (pHead != null) {
            next = pHead.next;
            if (next == null) pCopy.next = next;
            else if (map.containsKey(next)) pCopy.next = map.get(next);
            else {
                pCopy.next = new Node(next.val);
                map.put(next, pCopy.next);
            }
            random = pHead.random;
            if (random == null) pCopy.random = null;
            else if (map.containsKey(random)) pCopy.random = map.get(random);
            else {
                pCopy.random = new Node(random.val);
                map.put(random, pCopy.random);
            }
            pCopy = pCopy.next;
            pHead = pHead.next;
        }
        return copyHead;
    }
}
