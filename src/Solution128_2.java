import java.util.HashSet;
import java.util.Set;

public class Solution128_2 {

    /**
     * HashSet法，时间O(n)，空间O(n)
     * Runtime: 4 ms, faster than 95.72% of Java online submissions for Longest Consecutive Sequence.
     * Memory Usage: 41.2 MB, less than 5.17% of Java online submissions for Longest Consecutive Sequence.
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int cur = num;
                while (set.contains(cur + 1)) {
                    cur++;
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
