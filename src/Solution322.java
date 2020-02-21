import java.util.Arrays;

public class Solution322 {
    /**
     * 完全背包问题
     * f[i][j]=max(f[i−1][j],f[i][j−w[i]]+v[i])
     * 时间 O(V * N)，空间 O(V)
     * Runtime: 11 ms, faster than 78.54% of Java online submissions for Coin Change.
     * Memory Usage: 40.5 MB, less than 5.33% of Java online submissions for Coin Change.
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 初始化为不合法状态
        dp[0] = 0; // 只有容量为 0 的状态为合法状态
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
