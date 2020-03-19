import java.util.Arrays;

public class Solution279_2 {
    /**
     * dp，完全背包问题
     * 特点在于每个状态下，可选的物品只需计算 i * i <= j 即可
     * Runtime: 20 ms, faster than 75.03% of Java online submissions for Perfect Squares.
     * Memory Usage: 35.3 MB, less than 18.05% of Java online submissions for Perfect Squares.
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int j = 1; j <= n; j++)
            for (int i = 1; i * i <= j; i++)
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
        return dp[n];
    }

    public static void main(String[] args) {
        Solution279_2 solution279_2 = new Solution279_2();
        solution279_2.numSquares(12);
    }
}
