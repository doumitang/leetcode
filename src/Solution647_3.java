public class Solution647_3 {
    /**
     * 马拉车算法，时间 O(n)，空间 O(n)
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Palindromic Substrings.
     * Memory Usage: 38.1 MB, less than 7.60% of Java online submissions for Palindromic Substrings.
     * @param S
     * @return
     */
    public int countSubstrings(String S) {
        int len = S.length();
        char[] charArray = S.toCharArray();
        char[] str = new char[2 * len + 3];
        str[0] = '$';
        str[1] = '#';
        int t = 2;
        for (char c : charArray) {
            str[t++] = c;
            str[t++] = '#';
        }
        str[t] = '@';
        int[] p = new int[str.length];
        int center = 0, right = 0;
        for (int i = 1; i < str.length - 1; i++) {
            if (right > i) p[i] = Math.min(right - i, p[2 * center - i]);
            while (str[i + p[i]] == str[i - p[i]]) {
                p[i]++;
            }
            if (i + p[i] > right) {
                right = i + p[i];
                center = i;
            }
        }
        int ans = 0;
        for (int val : p) {
            ans += val / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution647_3 solution647_3 = new Solution647_3();
        System.out.println(solution647_3.countSubstrings("abc"));
    }
}
