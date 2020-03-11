import java.util.Arrays;

public class Solution621 {
    /**
     * 贪心思想，优先执行当前数量最多的任务
     * 数组重排序实现，时间 O(ans)，空间 O(1)
     * Runtime: 5 ms, faster than 63.96% of Java online submissions for Task Scheduler.
     * Memory Usage: 42.8 MB, less than 5.88% of Java online submissions for Task Scheduler.
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
        int ans = 0;
        while (counter[25] > 0) {
            for (int i = 0; i <= n; i++) {
                if (counter[25] == 0) break; // 最大值到 0 就 break 出去重排序，避免多算天数
                if (25 - i >= 0 && counter[25 - i] > 0) {
                    counter[25 - i]--;
                }
                ans++;
            }
            Arrays.sort(counter);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution621 solution621 = new Solution621();
        System.out.println(solution621.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
}
