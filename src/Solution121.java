public class Solution121 {
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
