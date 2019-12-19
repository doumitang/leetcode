public class Solution26 {
    /**
     * 双指针法
     * Runtime: 1 ms, faster than 97.95% of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 38.8 MB, less than 99.47% of Java online submissions for Remove Duplicates from Sorted Array.
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int len = nums.length;
        if (len < 2) return len;
        int p = 0, q = 1;
        while (p < len && q < len) {
            if (nums[q] == nums[p]) {
                q++;
            } else {
                swap(nums, ++p, q++);
            }
        }
        return p + 1;
    }

    public void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
