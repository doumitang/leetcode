import java.util.Stack;

public class Solution20 {
    /**
     * 用栈做括号匹配
     * Runtime: 2 ms, faster than 57.50% of Java online submissions for Valid Parentheses.
     * Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Valid Parentheses.
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            switch (c) {
                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                        continue;
                    }
                    break;
                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                        continue;
                    }
                    break;
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                        continue;
                    }
                    break;
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
