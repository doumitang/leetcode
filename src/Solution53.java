public class Solution53 {
    // 动态规划
    public int maxSubArray(int[] nums) {
        int ans = 0;
        if (nums.length == 0) return ans;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        for (int val : dp) ans = Math.max(ans, val);
        return ans;
    }
}
