public class Solution188_2 {
    /**
     * 最多可以完成 k 笔交易
     *
     * 执行用时：
     * 296 ms
     * , 在所有 Java 提交中击败了
     * 5.02%
     * 的用户
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int ans = 0;
        int n = prices.length;
        k = Math.min(k, n / 2); // 不判断 k 的话内存会超
        if (n == 0 || k == 0) return 0;
        int[][] buy = new int[2][k + 1];
        int[][] sell = new int[2][k + 1];
        buy[0][1] = -prices[0];
        for (int j = 2; j <= k; j++) {
            buy[0][j] = Integer.MIN_VALUE / 2;
        }
        for (int j = 1; j <= k; j++) {
            sell[0][j] = Integer.MIN_VALUE / 2;
        }
        boolean index = true;
        for (int count = 1; count <= n - 1; count++) {
            for (int j = 1; j <= k; j++) {
                int cur, pre;
                if (index) {
                    cur = 1;
                    pre = 0;
                } else {
                    cur = 0;
                    pre = 1;
                }
                buy[cur][j] = Math.max(buy[pre][j], sell[pre][j - 1] - prices[count]);
                sell[cur][j] = Math.max(sell[pre][j], buy[pre][j] + prices[count]);
                if (count == n - 1) {
                    ans = Math.max(Math.max(ans, buy[cur][j]), sell[cur][j]);
                }
            }
            index = !index;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution188_2 solution188 = new Solution188_2();
        solution188.maxProfit(2, new int[]{2, 4, 1});
    }
}
