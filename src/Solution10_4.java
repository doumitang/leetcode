public class Solution10_4 {
    /**
     * 自己实现的二维 dp 解法
     *
     * Runtime: 2 ms, faster than 92.40% of Java online submissions for Regular Expression Matching.
     * Memory Usage: 38.5 MB, less than 45.45% of Java online submissions for Regular Expression Matching.
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        boolean[][] dp = new boolean[sArray.length + 1][pArray.length + 1];
        dp[0][0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (pArray[j - 1] == '*') {
                    if (j - 2 >= 0) dp[i][j] = dp[i][j] || dp[i][j - 2];
                    if (i - 1 >= 0) dp[i][j] = dp[i][j] || dp[i - 1][j] && (pArray[j - 2] == '.' || sArray[i - 1] == pArray[j - 2]);
                } else {
                    if (i - 1 >= 0) {
                        boolean curMatch = pArray[j - 1] == '.' || sArray[i - 1] == pArray[j - 1];
                        dp[i][j] = curMatch && dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[sArray.length][pArray.length];
    }

    public static void main(String[] args) {
        Solution10_4 solution10_4 = new Solution10_4();
        System.out.println(solution10_4.isMatch("mississippi"
                ,"mis*is*p*."));
    }
}
