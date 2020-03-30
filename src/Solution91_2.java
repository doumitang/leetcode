public class Solution91_2 {
    /**
     * dp 解法，比递归 + dp 快这么多。。
     * Runtime: 2 ms, faster than 58.55% of Java online submissions for Decode Ways.
     * Memory Usage: 38.3 MB, less than 5.66% of Java online submissions for Decode Ways.
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 1;
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int first = 0;
            int num1 = s.charAt(i) - '0';
            if (num1 >= 1 && num1 <= 26) {
                first = dp[i + 1];
            }
            int second = 0;
            if (i <= s.length() - 2) {
                String str = s.substring(i, i + 2);
                if (str.charAt(0) != '0') {
                    int num2 = Integer.valueOf(str);
                    if (num2 >= 1 && num2 <= 26) {
                        second = dp[i + 2];
                    }
                }
            }
            dp[i] = first + second;
        }
        return dp[0];
    }
}
