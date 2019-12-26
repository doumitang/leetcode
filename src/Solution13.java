import java.util.HashMap;
import java.util.Map;

public class Solution13 {
    /**
     * 关键：减法的情况都是只包含一个在左边的字符
     * Runtime: 6 ms, faster than 51.70% of Java online submissions for Roman to Integer.
     * Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Roman to Integer.
     * @param s
     * @return
     */
    /*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
     */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int temp = map.get(c);
            if (i < len - 1) {
                char next = s.charAt(i + 1);
                if (c == 'I' && (next == 'V' || next == 'X')) temp = -temp;
                if (c == 'X' && (next == 'L' || next == 'C')) temp = -temp;
                if (c == 'C' && (next == 'D' || next == 'M')) temp = -temp;
            }
            ans += temp;
        }
        return ans;
    }
}
