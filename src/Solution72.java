public class Solution72 {
    public int minDistance(String word1, String word2) {
        return Math.max(word1.length(), word2.length()) - getLCS(word1, word2);
    }

    // 最长公共子序列
    private int getLCS(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        System.out.println(dp[m][n]);
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution72 solution72 = new Solution72();
        System.out.println(solution72.minDistance("intention", "execution"));
    }
}
