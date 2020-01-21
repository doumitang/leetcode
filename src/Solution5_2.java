public class Solution5_2 {
    /**
     * Manacher算法，时间复杂度O(n)
     * 因为算法只有遇到还没有匹配的位置时才进行匹配
     * 已经匹配过的位置不再进行匹配
     * 所以对于T字符串中的每一个位置
     * 只进行一次匹配
     * 所以Manacher算法的总体时间复杂度为O(n)
     * 其中n为T字符串的长度
     * 由于T的长度事实上是S的两倍
     * 所以时间复杂度依然是线性的。
     * Runtime: 7 ms, faster than 69.12% of Java online submissions for Longest Palindromic Substring.
     * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Longest Palindromic Substring.
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        // 转换字符串
        StringBuilder str = new StringBuilder();
        str.append("#");
        for (int i = 0; i < s.length(); i++) {
            str.append(s.charAt(i));
            str.append("#");
        }
        // 指向最大右端点的下一个位置
        int rightIndex = 1, centerIndex = 0;
        int maxLen = 0, start = 0;
        // len数组，记录回文半径
        int[] len = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            // 当rightIndex > i，那么我们就在rightIndex - i 与len[2 * centerIndex - i](len[j])，取得最小值
            // 因为当i + len[j] < rightIndex时，我们就把len[i]更新为len[j]
            // 但是如果i + len[j] >= rightIndex时，我们暂且将len[i]定更新为rightIndex - i,超出的部分需要我们一个一个的匹配
            if (rightIndex > i) {
                len[i] = Math.min(rightIndex - i, len[2 * centerIndex - i]);
            } else {
                len[i] = 1;
            }
            // 一个一个匹配，要么是超出的部分，要么是i > rightIndex
            while (i - len[i] >= 0 && i + len[i] < str.length() && str.charAt(i - len[i]) == str.charAt(i + len[i])) {
                len[i]++;
            }
            // 当 len[i] + i > rightIndex,我们需要更新centerIndex和rightIndex
            // 至于为什么会这样做，理解一下rightIndex和centerIndex的含义
            if (len[i] + i > rightIndex) {
                rightIndex = len[i] + i;
                centerIndex = i;
            }
            if (len[i] - 1 > maxLen) {
                maxLen = len[i] - 1;
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }
}
