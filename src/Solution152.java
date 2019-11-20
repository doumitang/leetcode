public class Solution152 {
    // foreach比for快？？？
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dpMax = new int[n], dpMin = new int[n];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        /*int ans = dpMax[0];*/
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
            dpMin[i] = Math.min(Math.min(dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]), nums[i]);
            /*ans = Math.max(ans, dpMax[i]);*/
        }
        int ans = Integer.MIN_VALUE;
        for (int val : dpMax) {
            ans = Math.max(ans, val);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,-1,1,1};
        Solution152 solution152 = new Solution152();
        solution152.maxProduct(nums);
    }
}
