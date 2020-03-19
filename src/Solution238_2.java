public class Solution238_2 {
    /**
     * Left and Right product lists
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
     * Memory Usage: 41.3 MB, less than 100.00% of Java online submissions for Product of Array Except Self.
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        for (int left = 1; left < len; left++) {
            ans[left] = ans[left - 1] * nums[left - 1];
        }
        int productRight = 1;
        for (int right = len - 1; right >= 0; right--) {
            ans[right] *= productRight;
            productRight *= nums[right];
        }
        return ans;
    }
}
