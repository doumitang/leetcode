import java.util.Arrays;

public class Solution188 {
    /**
     * 最多可以完成 k 笔交易
     *
     * 内存超了
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int ans = 0;
        int n = prices.length;
        k = Math.min(k, n / 2);
        if (n == 0 || k == 0) return 0;
        int[][] buy = new int[n + 1][k + 1];
        int[][] sell = new int[n + 1][k + 1];
        buy[1][1] = -prices[0];
        for (int j = 2; j <= k; j++) {
            buy[1][j] = Integer.MIN_VALUE / 2;
        }
        for (int j = 1; j <= k; j++) {
            sell[1][j] = Integer.MIN_VALUE / 2;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j - 1] - prices[i - 1]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j] + prices[i - 1]);
                if (i == n) {
                    ans = Math.max(Math.max(ans, buy[i][j]), sell[i][j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution188 solution188 = new Solution188();
        solution188.maxProfit(2, new int[]{2, 4, 1});
    }
}
