public class Solution221_3 {
    // 节省了空间复杂度，DP思想一样
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
        int[] dp = new int[n + 1];
        int res = 0, pre = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j], pre), dp[j - 1]) + 1;
                    res = Math.max(res, dp[j]);
                } else {
                    dp[j] = 0;
                }
                pre = temp;
            }
        }
        return res * res;
    }
}
