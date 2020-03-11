import java.util.*;

public class Solution621_2 {
    /**
     * 贪心思想，优先执行当前数量最多的任务
     * 优先队列（堆）实现，时间 O(ans)，空间 O(1)
     * Runtime: 24 ms, faster than 42.50% of Java online submissions for Task Scheduler.
     * Memory Usage: 42.5 MB, less than 5.88% of Java online submissions for Task Scheduler.
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int[] counter = new int[26];
        for (char task : tasks) {
            counter[task - 'A']++;
        }
        for (int count : counter) {
            if (count > 0) queue.offer(count);
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1) {
                        temp.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                ans++;
                if (queue.isEmpty() && temp.size() == 0) return ans;
            }
            for (Integer count : temp) {
                if (count > 0) queue.offer(count);
            }
        }
        return ans;
    }
}
