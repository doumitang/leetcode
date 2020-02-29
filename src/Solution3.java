import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    /**
     * 滑动窗口，时间O(2n)，空间O(n)
     * Runtime: 9 ms, faster than 52.77% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 36.6 MB, less than 99.76% of Java online submissions for Longest Substring Without Repeating Characters.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, ans = 0;
        int len = s.length();
        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++)); // i 自增，表示以位置 i 为开头的最长不重复子串计算结束
            }
            ans = Math.max(ans, set.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int ans = solution3.lengthOfLongestSubstring(" ");
        System.out.println(ans);
    }
}
