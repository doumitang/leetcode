import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution20_2 {
    /**
     * Runtime: 2 ms, faster than 57.50% of Java online submissions for Valid Parentheses.
     * Memory Usage: 34.1 MB, less than 100.00% of Java online submissions for Valid Parentheses.
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) stack.push(c); // 如果是左括号，直接push进来
            else {
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (top != map.get(c)) return false;
            }
        }
        return stack.isEmpty();
    }
}
