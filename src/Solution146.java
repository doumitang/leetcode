import java.util.LinkedList;
import java.util.Queue;

class LRUCache {

    class Tuple {
        int key, val;
        public Tuple(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Queue<Tuple> queue;

    private int capacity;

    public LRUCache(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int res = -1;
        for (Tuple tuple:queue) {
            if (tuple.key == key) {
                res = tuple.val;
                queue.remove(tuple);
                queue.offer(tuple);
                break;
            }
        }
        return res;
    }

    public void put(int key, int value) {
        for (Tuple tuple:queue) {
            if (tuple.key == key) {
                queue.remove(tuple);
                queue.offer(new Tuple(key, value));
                return;
            }
        }
        if (queue.size() < capacity) {
            queue.offer(new Tuple(key, value));
        } else {
            queue.poll();
            queue.offer(new Tuple(key, value));
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */