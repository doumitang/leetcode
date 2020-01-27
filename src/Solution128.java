import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution128 {
    /*
     * 1. 暴力法：
     * 以每个元素为序列的开始元素，如果数组中包含 +1 的元素，则计数器 +1，直到不含有 +1 的元素结束
     * 时间O(n ^ 3)，空间O(1)
     *
     * 2. 排序法（很容易想到的是这个）
     * 时间O(nlogn)，空间O(1)
     *
     * 3. 暴力法的改进
     * 利用 HashSet 存储，时间O(n)，空间O(n)
     * @param nums
     * @return
     *
     * 4. 并查集法
     * 时间接近O(n)，空间O(n)
     */

    /**
     * 排序法（最容易想到的），注意：有可能存在重复元素
     * 时间O(nlogn)，空间O(1)
     * Runtime: 4 ms, faster than 95.72% of Java online submissions for Longest Consecutive Sequence.
     * Memory Usage: 40.7 MB, less than 8.62% of Java online submissions for Longest Consecutive Sequence.
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = 1, count = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    count++;
                } else {
                    ans = Math.max(ans, count);
                    count = 1;
                }
            }
        }
        return Math.max(ans, count);
    }
}
