import java.util.*;

public class Solution347 {
    /**
     * 和求最大的 k 个数类似，用最小堆，区别在于先要用 map 记录每个元素的出现频率，时间O(n * logk)，空间O(n)
     * Runtime: 10 ms, faster than 86.69% of Java online submissions for Top K Frequent Elements.
     * Memory Usage: 42.4 MB, less than 7.76% of Java online submissions for Top K Frequent Elements.
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            int cur = counter.getOrDefault(num, 0);
            counter.put(num, cur + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return counter.get(o1) - counter.get(o2);
            }
        });
        for (Integer integer : counter.keySet()) {
            heap.add(integer);
            if (heap.size() > k) heap.poll();
        }

        List<Integer> ans = new ArrayList<>();
        while (!heap.isEmpty()) {
            ans.add(heap.poll());
        }
        return ans;
    }
}
