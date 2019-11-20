import java.util.*;

class LRUCache2 {

    private Map<Integer, Integer> map;

    private int capacity;

    public LRUCache2(int capacity) {
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer res = map.get(key);
        if (res != null) {
            map.remove(key);
            map.put(key, res);
            return res;
        }
        return -1;
    }

    public void put(int key, int value) {
        map.remove(key);
        if (map.size() >= capacity) {
            int keyLRU = map.entrySet().iterator().next().getKey();
            map.remove(keyLRU); // 删除首元素
        }
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */