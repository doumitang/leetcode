import java.util.Arrays;

public class Solution5 {
    /**
     * 验证阶段可以用的上dp，时间O(n^2)，空间O(n^2)，空间可优化至O(n)
     * 另外还有从中心展开的方法，时间O(n^2)，空间O(1)
     * Runtime: 45 ms, faster than 35.64% of Java online submissions for Longest Palindromic Substring.
     * Memory Usage: 37.2 MB, less than 93.95% of Java online submissions for Longest Palindromic Substring.
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        char[] array = s.toCharArray();
        int len = array.length;
        boolean[][] dp = new boolean[len][len];
        int left = 0, right = 0;
        // dp二维数组从下往上算就可以，太秀了
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) dp[i][j] = true;
                else if (i + 1 == j) dp[i][j] = array[i] == array[j];
                else dp[i][j] = dp[i + 1][j - 1] && array[i] == array[j];
                if (dp[i][j] && j - i > right - left) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("cbbd"));
    }
}
