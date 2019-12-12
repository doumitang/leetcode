import java.util.HashMap;
import java.util.Map;

public class Solution13_2 {
    /**
     * Runtime: 5 ms, faster than 59.33% of Java online submissions for Roman to Integer.
     * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Roman to Integer.
     * @param s
     * @return
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
        int cur = 0, pre = 0;
        for (int i = 0; i < len; i++) {
            cur = map.get(s.charAt(i));
            ans += cur;
            if (cur > pre) ans -= 2 * pre;
            pre = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution13_2 solution13_2 = new Solution13_2();
        System.out.println(solution13_2.romanToInt("IV"));
    }
}
