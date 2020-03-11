import java.util.Arrays;

public class Solution621_3 {
    /**
     * 计算空槽的个数，最后与总的任务数相加
     * 时间 O(lenof(tasks))，空间 O(1)
     * Runtime: 2 ms, faster than 99.68% of Java online submissions for Task Scheduler.
     * Memory Usage: 42.9 MB, less than 5.88% of Java online submissions for Task Scheduler.
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        int[] counter = new int[26];
        for (char task : tasks) {
            counter[task - 'A']++;
        }
        Arrays.sort(counter);
        int idleSlots = (counter[25] - 1) * n;
        for (int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(counter[i], counter[25] - 1);
        }
        return idleSlots > 0 ? tasks.length + idleSlots : tasks.length;
    }
}
