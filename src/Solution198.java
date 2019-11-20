import java.util.Arrays;

public class Solution198 {
    // 复杂度没问题，但是情况没完全考虑清楚
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[len];
        boolean[] selected = new boolean[len];
        dp[0] = nums[0];
        selected[0] = true;
        if (nums[1] > nums[0]) {
            dp[1] = nums[1];
            selected[1] = true;
        } else {
            dp[1] = nums[0];
        }
        for (int i = 2; i < len; i++) {
            if (selected[i - 1]) {
                if (dp[i - 2] + nums[i] > dp[i - 1]) {
                    dp[i] = dp[i - 2] + nums[i];
                    selected[i] = true;
                } else dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + nums[i];
                selected[i] = true;
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(selected));
        return dp[len - 1];
    }

    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        int[] nums = {2, 7, 9, 3, 1};
        solution198.rob(nums);
    }
}
