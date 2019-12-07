import java.util.HashMap;
import java.util.Map;

public class Solution3_2 {
    /**
     * 滑动窗口改进版，可以直接用map找到重复元素的位置
     * 时间O(n)，空间O(n)
     * Runtime: 8 ms, faster than 65.35% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 36 MB, less than 100.00% of Java online submissions for Longest Substring Without Repeating Characters.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int ans = 0, len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) i = Math.max(i, map.get(s.charAt(j)));
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
