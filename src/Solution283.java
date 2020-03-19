public class Solution283 {
    /**
     * 考虑非0区的指针
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
     * Memory Usage: 37.8 MB, less than 100.00% of Java online submissions for Move Zeroes.
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int pNotZero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, ++pNotZero, i);
            }
        }
    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
