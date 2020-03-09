public class Solution647_2 {
    /**
     * 从中心扩展的方法，一共 2 * n - 1个中心，时间 O(n ^ 2)，空间 O(1)
     * Runtime: 3 ms, faster than 70.24% of Java online submissions for Palindromic Substrings.
     * Memory Usage: 37.9 MB, less than 8.86% of Java online submissions for Palindromic Substrings.
     * @param S
     * @return
     */
    public int countSubstrings(String S) {
        int N = S.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
