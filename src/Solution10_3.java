public class Solution10_3 {

    private boolean[][] dp;

    /**
     * 自底向上的dp
     * Runtime: 2 ms, faster than 92.81% of Java online submissions for Regular Expression Matching.
     * Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Regular Expression Matching.
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        dp = new boolean[sArray.length + 1][pArray.length + 1];
        // 第pArray.length列，只有最后一项为true，其余都为false
        dp[sArray.length][pArray.length] = true;
        for (int i = sArray.length; i >= 0; i--) {
            for (int j = pArray.length - 1; j >= 0; j--) {
                boolean firstMatch = i < sArray.length && (sArray[i] == pArray[j] || pArray[j] == '.');
                if (j + 1 < pArray.length && pArray[j + 1] == '*') {
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
