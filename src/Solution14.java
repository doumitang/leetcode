public class Solution14 {
    /**
     * 暴力法
     * Runtime: 1 ms, faster than 74.92% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 38.3 MB, less than 76.02% of Java online submissions for Longest Common Prefix.
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        int minLen = Integer.MAX_VALUE; // 防止数组越界
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        for (int j = 0; j < minLen; j++) {
            char base = strs[0].charAt(j);
            for (String str : strs) {
                if (str.charAt(j) != base) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(base);
        }
        return stringBuilder.toString();
    }
}
