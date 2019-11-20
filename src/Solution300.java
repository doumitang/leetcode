import java.util.Arrays;

public class Solution300 {
    /**
     * 动态规划，O(n^2)
     * Runtime: 11 ms, faster than 39.56% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Longest Increasing Subsequence.
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return 1;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        // System.out.println(Arrays.toString(dp));
        return ans;
    }

    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        int[] nums = {1,3,6,7,9,4,10,5,6};
        solution300.lengthOfLIS(nums);
    }
}
