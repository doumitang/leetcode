class Solution238 {
    /**
     * Time Limit Exceeded
     * 时间复杂度O(n^2)
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int product = 1;
            for (int j = 0; j < len; j++) {
                if (j != i) product *= nums[j];
            }
            ans[i] = product;
        }
        return ans;
    }
}