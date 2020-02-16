public class Solution309 {
    /**
     * dp，关键在于状态的定义，时间 O(n)，空间 O(n)
     * sell[i]表示截至第i天，最后一个操作是卖时的最大收益；
     * buy[i]表示截至第i天，最后一个操作是买时的最大收益；
     * cool[i]表示截至第i天，最后一个操作是冷冻期时的最大收益；
     * 递推公式：
     * sell[i] = max(buy[i-1]+prices[i], sell[i-1]) (第一项表示第i天卖出，第二项表示在之前卖的，第i天冷冻)
     * buy[i] = max(cool[i-1]-prices[i], buy[i-1]) （第一项表示第i天买进，第二项表示在之前买的，第i天冷冻）
     * cool[i] = max(sell[i-1], buy[i-1], cool[i-1])
     *
     * Runtime: 1 ms, faster than 57.76% of Java online submissions for Best Time to Buy and Sell Stock with Cooldown.
     * Memory Usage: 37.8 MB, less than 25.93% of Java online submissions for Best Time to Buy and Sell Stock with Cooldown.
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[] sell = new int[len], buy = new int[len], cool = new int[len];
        buy[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
            buy[i] = Math.max(cool[i - 1] - prices[i], buy[i - 1]);
            cool[i] = Math.max(sell[i - 1], Math.max(buy[i - 1], cool[i - 1]));
        }
        return Math.max(sell[len - 1], Math.max(buy[len - 1], cool[len - 1]));
    }
}
