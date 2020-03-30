public class Solution91 {
    private int[] dp;

    /**
     * 递归 + dp，怎么这么慢。。
     * Runtime: 68 ms, faster than 6.40% of Java online submissions for Decode Ways.
     * Memory Usage: 40.6 MB, less than 5.66% of Java online submissions for Decode Ways.
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 1;
        dp = new int[s.length()];
        return numDecodingsCore(s, 0);
    }

    private int numDecodingsCore(String s, int index) {
        if (index == s.length()) return 1;
        if (dp[index] != 0) return dp[index];
        int first = 0;
        int num1 = s.charAt(index) - '0';
        if (num1 >= 1 && num1 <= 26) {
            first = numDecodingsCore(s, index + 1);
        }
        int second = 0;
        if (index <= s.length() - 2) {
            String str = s.substring(index, index + 2);
            if (str.charAt(0) != '0') {
                int num2 = Integer.valueOf(str);
                if (num2 >= 1 && num2 <= 26) {
                    second = numDecodingsCore(s, index + 2);
                }
            }
        }
        dp[index] = first + second;
        return dp[index];
    }

    public static void main(String[] args) {
        Solution91 solution91 = new Solution91();
        solution91.numDecodings("10");
    }
}
