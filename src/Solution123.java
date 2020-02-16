public class Solution123 {
    /**
     * 本题和前两题都可以用状态方程来表示，即使用 dp 求解，时间O(n)，空间O(1)
     * 由于限制最多两次交易，所以也就是以下几种状态：
     * buy1, sell1, buy2, sell2
     * 分别为第一次买，第一次卖，第二次买，第二次卖
     * Runtime: 2 ms, faster than 66.78% of Java online submissions for Best Time to Buy and Sell Stock III.
     * Memory Usage: 43 MB, less than 7.32% of Java online submissions for Best Time to Buy and Sell Stock III.
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
