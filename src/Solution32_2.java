class Solution32_2 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == ')') {
                // ......()
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // ......))
                    dp[i] = (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
            }
            ans = dp[i] > ans ? dp[i] : ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution32_2 solution = new Solution32_2();
        System.out.println(solution.longestValidParentheses(")()"));
    }
}
