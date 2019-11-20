public class Solution581 {
    /**
     * O(n^2)
     * Runtime: 294 ms, faster than 5.83% of Java online submissions for Shortest Unsorted Continuous Subarray.
     * Memory Usage: 60.4 MB, less than 7.69% of Java online submissions for Shortest Unsorted Continuous Subarray.
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (right - left + 1 >= 2) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }
            if (nums[left] != min && nums[right] != max) return right - left + 1;
            if (nums[left] == min) left++;
            if (nums[right] == max) right--;
        }
        return 0;
    }
}
