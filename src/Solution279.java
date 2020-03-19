import java.util.Arrays;

public class Solution279 {
    /**
     * 满完全背包解法
     * Runtime: 69 ms, faster than 19.58% of Java online submissions for Perfect Squares.
     * Memory Usage: 48.1 MB, less than 12.50% of Java online submissions for Perfect Squares.
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        int[][] dp = new int[sqrt + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            if (j == 0) dp[0][j] = 0;
            else dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= Math.sqrt(n); i++)
            for (int j = 0; j <= n; j++) {
                if (j >= i * i) dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - i * i] + 1);
                else dp[i][j] = dp[i - 1][j];
            }
//        for (int[] array:dp)
//            System.out.println(Arrays.toString(array));
        return dp[sqrt][n];
    }

    public static void main(String[] args) {
        Solution279 solution279 = new Solution279();
        solution279.numSquares(12);
    }
}
