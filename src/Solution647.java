public class Solution647 {
    /**
     * dp，时间 O(n ^ 2)，空间 O(n ^ 2)
     * Runtime: 7 ms, faster than 47.40% of Java online submissions for Palindromic Substrings.
     * Memory Usage: 42.5 MB, less than 5.07% of Java online submissions for Palindromic Substrings.
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        char[] str = s.toCharArray();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int ans = len;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (j == i + 1) dp[i][j] = str[i] == str[j];
                else dp[i][j] = dp[i + 1][j - 1] && str[i] == str[j];
                if (dp[i][j]) ans++;
            }
        }
        return ans;
    }
}
