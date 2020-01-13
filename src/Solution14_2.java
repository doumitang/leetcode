public class Solution14_2 {
    /**
     * 分治法
     * Runtime: 1 ms, faster than 74.92% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 37.7 MB, less than 83.04% of Java online submissions for Longest Common Prefix.
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefixCore(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefixCore(String[] strs, int start, int end) {
        if (start == end) return strs[start];
        int mid = (start + end) / 2;
        String ans1 = longestCommonPrefixCore(strs, start, mid);
        String ans2 = longestCommonPrefixCore(strs, mid + 1, end);
        return merge(ans1, ans2);
    }

    public String merge(String str1, String str2) {
        int min = Math.min(str1.length(), str2.length());
        for (int i = 0; i < min; i++) {
            if (str1.charAt(i) != str2.charAt(i)) return str1.substring(0, i);
        }
        return str1.substring(0, min);
    }

    public static void main(String[] args) {
        Solution14_2 solution14 = new Solution14_2();
        String[] strs = {"flower","flow","flight"};
        System.out.println(solution14.longestCommonPrefix(strs));
    }
}
