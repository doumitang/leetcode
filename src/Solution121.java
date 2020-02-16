public class Solution121 {
    /**
     * 第 i 天卖出的最大利润需要找到之前的最低谷
     * 所以遍历的过程中记录最低谷，同时记录最大利润值，时间O(n)，空间O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int ans = 0, minVal = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minVal = Math.min(minVal, prices[i]);
            ans = Math.max(ans, prices[i] - minVal);
        }
        return ans;
    }
}
