public class Solution581_2 {
    /**
     * 时间O(n)，空间O(1)，是对栈方法的空间改进
     * Runtime: 3 ms, faster than 67.53% of Java online submissions for Shortest Unsorted Continuous Subarray.
     * Memory Usage: 40.4 MB, less than 100.00% of Java online submissions for Shortest Unsorted Continuous Subarray.
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }
        int left, right;
        for (left = 0; left < len; left++) {
            if (min < nums[left]) break;
        }
        for (right = len - 1; right >= 0; right--) {
            if (max > nums[right]) break;
        }
        return left > right ? 0 : right - left + 1;
    }
}
