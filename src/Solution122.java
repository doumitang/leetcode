public class Solution122 {
    /**
     * 比前一天价格高，就把利润加上去，时间O(n)，空间O(1)
     * Runtime: 1 ms, faster than 89.60% of Java online submissions for Best Time to Buy and Sell Stock II.
     * Memory Usage: 42.5 MB, less than 5.71% of Java online submissions for Best Time to Buy and Sell Stock II.
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }
}
