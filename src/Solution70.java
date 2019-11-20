import java.util.Arrays;

public class Solution70 {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        dp[n - 2] = 2;
        for (int i = n - 3; i >= 0; i--) {
            System.out.println(i);
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        System.out.println(solution70.climbStairs(3));
    }
}
