import java.util.Stack;

public class Solution739_2 {
    /**
     * 单调栈，关键在于找到最近的比当前数值大的，时间 O(n)，空间 O(n)
     * Runtime: 16 ms, faster than 63.98% of Java online submissions for Daily Temperatures.
     * Memory Usage: 45.5 MB, less than 13.56% of Java online submissions for Daily Temperatures.
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return null;
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
