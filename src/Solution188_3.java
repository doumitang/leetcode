public class Solution188_3 {
    /**
     * 本质没变，换成三维 dp 数组
     * 关键在于 k 表示最多允许 k 次交易，导致初始化有一点不同
     * 还有就是当 k > n / 2的时候问题就成了无限次交易，就只需要二维 dp 就可以了，避免超过内存
     *
     * 执行用时：
     * 10 ms
     * , 在所有 Java 提交中击败了
     * 55.72%
     * 的用户
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int ans = 0;
        int n = prices.length;
        if (k > n / 2) {
            int[][] dp = new int[n + 1][2];
            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    dp[i][0] = 0;
                    dp[i][1] = -prices[0];
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
            }
            return dp[n][0];
        }
        if (n == 0 || k == 0) return 0;
        int[][][] dp = new int[n + 1][k + 1][2];
        for (int i = 1; i <= n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE; // 最多允许 0 次交易，不得持有股票（非法状态）
            for (int j = 1; j <= k; j++) {
                if (i == 1) {
                    dp[i][j][0] = 0; // 没有持有股票的情况
                    dp[i][j][1] = -prices[i - 1]; // 持有股票的情况
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        return dp[n][k][0];
    }

    public static void main(String[] args) {
        Solution188_3 solution188 = new Solution188_3();
        solution188.maxProfit(2, new int[]{2, 4, 1});
    }
}
