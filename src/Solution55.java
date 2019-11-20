import java.util.Arrays;

public class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int target = nums.length - 1;
        boolean[] dp = new boolean[nums.length - 1];
        for (int i = target - 1; i >= 0; i--) {
//            System.out.println(i);
            if (nums[i] >= target - i) {
                dp[i] = true;
                continue;
            }
            for (int j = i + 1; j <= Math.min(i + nums[i], target - 1); j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        int[] nums = {0, 2, 3};
        System.out.println(solution55.canJump(nums));
    }
}
